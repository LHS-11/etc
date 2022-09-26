스프링 시큐리티

application.yml 로 하면 중복을 없애고 설정 가능

ex) application.properties 의 경우
```
spring.datasource.driver-class-name: com.mysql.cj.jdbc.Driver
spring.datasource.url: jdbc:mysql://localhost:3307/security?serverTimezone=Asia/Seoul
spring.datasource.username: cos
spring.datasource.password: cos1234
```
이런식으로 해야 하는데
application.yml 같은 경우
```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3307/security?serverTimezone=Asia/Seoul
    username: cos
    password: cos1234
```
이런식으로 계층적 구조로 표현하기 더 편리하다.

Mustache 의존성 등록시 기본적으로 설정됨
머스테치 기본경로 => src/main/resources/
뷰리졸버 설정 => templates (prefix), .mustache (suffix) 생략 가능


머스테치 뷰리졸버 설정 가능
```
@Configuration // 설정 관련
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        MustacheViewResolver resolver = new MustacheViewResolver();

        resolver.setCharset("UTF-8");
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setPrefix("classpath:/templates/"); // classpath => 프로젝트 이름
        resolver.setSuffix(".html"); // .html 파일로 만들어도 머스테치가 인식 가능

        registry.viewResolver(resolver);
    }
}
```

Spring Security 로 설정시
기본적으로 인증이 필요한 서버가 됨 => SecurityConfig 파일 설정시 login 권한 해제 가능

@ResponseBody 사용시 뷰 리졸버 사용하지 않고 바로 http 의 body 에 문자 내용 출력 가능

Spring Security 권한 설정
ex)
```
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터 체인에 등록이 됨
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true) // Secured 어노테이션 활성화, preAuthorize, postAuthorize 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter { // spring security 5.7이상에서 더 이상 WebSecurityConfigurerAdapter 사용을 권장하지 않음


//    @Bean // 해당 메서드로 리턴되는 IOC 로 등록해줌
//    public BCryptPasswordEncoder encoderPwd(){ => 시큐리티 로그인을 위해 패스워드를 암호화
//        return new BCryptPasswordEncoder();
//    } // 비밀번호 암호화

    private final PrincipalOauth2UserService principalOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable(); //csrf 비활성화

        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() // /user/** 라는 주소가 입력되면 인증이 필요함
                // authenticated => ROLE_ADMIN 역할 필요 , 인증만 되면 들어갈 수 있는 주소
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')") // ROLE_ADMIN or ROLE_MANAGER 권한이 있는 사람만
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") //  ROLE_ADMIN 권한만
                .anyRequest().permitAll() // 위 세개의 주소가 아닌 다른 주소는 모두 허용
                .and()
                .formLogin() // 권한이 없는 페이지에 들어갈 때
                .loginPage("/loginForm") // /loginForm 페이지로 이동 됨
                .loginProcessingUrl("/login") // login 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행해줌
                .defaultSuccessUrl("/") // 해당 페이지에서 로그인 요청시 로그인 성공시 해당 페이지로 이동
                .and()
                .oauth2Login()
                .loginPage("/loginForm") // tip. 코드 X (액세스 토큰 + 사용자 프로필 정보) / 액세스 토큰으로 사용자 프로필 정보를 받음
                .userInfoEndpoint()
                .userService(principalOauth2UserService);

    }
}

```

시큐리티 세션에서 로그인 (유저 정보를 가져오기) 위한 설정 (Authentication => UserDetails (PrincipalDetails))
```
// 시큐리티가 /login 주소 요청시 낚아채서 로그인을 진행
// 로그인이 진행이 완료되면 시큐리티 session 을 만들어줌 (Security ContextHolder) => 세션정보 저장
// 오브젝트 => Authentication 타입 객체
// Authentication 안에 User 정보가 있어야 함
// User 오브젝트 타입 => User Details 타입 객체
// Security Session => Authentication => UserDetails (PrincipalDetails)

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {


    private User user; // 컴포지션

    private Map<String,Object> attributes;

    // 일반 로그인할 때 생성자
    public PrincipalDetails(User user) {
        this.user = user;
    }

    // oauth 로그인할 때 생성자
    public PrincipalDetails(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }


    //해당 유저의 권한을 리턴 => userRole 이 필요함 그냥 String 으로 반환 X
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });

        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override // 계정이 잠겼는지 확인
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override // 유효기간 안지났는지 확인
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override // 계정 활성화 되있는지
    public boolean isEnabled() {
         // 1년 동안 회원이 로그인을 안하면 휴먼 계정으로 변경 가능
         
        return true;
    }

    @Override
    public String getName() {
        return null;
    }


}
```

Security Session => Authentication
로그인 시
-> 유저 정보 찾고
-> 그 유저 정보를 UserDetails(PrincipalDetails) 에 넣고
-> UserDetails(PrincipalDetails) 을 Authenticated 에 넣고
-> 시큐리티 세션에 Authenticated 을 넣음으로써 로그인 함

```
//시큐리티 설정에서 loginProcessingUrl("/login");
// /login 요청이 오면 자동으로 UserDetailService 타입으로 IoC 되어 있는 loadUserByUsername 함수가 실행
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // 함수 종료시 @AuthenticationPrincipal 어노테이션이 생성
    // 시큐리티 session =Authenticated = UserDetails
    // -> 시큐리티 session(내부 Authentication (내부 UserDetails))

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // html 에서 파라미터가 넘어올 때 username 이름이 동일해야 함 
        // => 만약 바꾸고 싶으면 SecurityConfig 에서 usernameParameter 안에 바꿔줘야함

        User userEntity = userRepository.findByUsername(username);

        if (userEntity != null) {
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}

```



자기만의 시큐리티 세션 들고 있음

서버 자체의 session (안에 시큐리티가 관리하는 시큐리티 session 이 존재)

시큐리티 세션에서 들어올 수 있는 타입은 Authentication 객체 ( controller 에서 DI 가능)

Authentication
1) UserDetails -> 일반적인 로그인
2) Oauth2User -> OAuth 로그인 (구글, 네이버 등)
   => 위 두 개를 PrincipalDetails 타입으로 묶어버리면 그냥 PrincipalDetails 공통적으로 사용하면 됨

Provider => 구글, 페이스북, 트위터 등

각 사이트들마다 getAttributes 로 넘겨주는 값이 다르기 때문에 Spring 에서 다 만들어놓을 수 없음

