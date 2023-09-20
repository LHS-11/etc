package com.cos.security1.config;

import com.cos.security1.config.auth.ouath.PrincipalOauth2UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 구글 로그인이 완료된 뒤의 후처리가 필요함. 1) 코드 받기(인증) 2) 엑세스 토큰(권한)
// 3) 사용자 프로필 정보를 가져와서 4-1) 그 정보를 토대로 회원가입을 자동으로 진행시키기도 함
// 4-2) (이메일, 전화번호, 이름, 아이디) 쇼핑몰 -> (집 주소), 백화점 몰 -> (vip 등급, 일반 등급)


@Configuration
@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터 체인에 등록이 됨
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true) // Secured 어노테이션 활성화, preAuthorize, postAuthorize 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Bean // 해당 메서드로 리턴되는 IOC 로 등록해줌
//    public BCryptPasswordEncoder encoderPwd(){
//        return new BCryptPasswordEncoder();
//    } // 비밀번호 암호화

    private final PrincipalOauth2UserService principalOauth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() // authenticated => ROLE_ADMIN 역할 필요 , 인증만 되면 들어갈 수 있는 주소
                //.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login") // login 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행해줌
                .defaultSuccessUrl("/")
                .and()
                .oauth2Login()
                .loginPage("/loginForm") // tip. 코드 X (액세스 토큰 + 사용자 프로필 정보) / 액세스 토큰으로 사용자 프로필 정보를 받음
                .userInfoEndpoint()
                .userService(principalOauth2UserService);

    }
}
