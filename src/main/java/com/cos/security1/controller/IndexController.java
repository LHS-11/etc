package com.cos.security1.controller;

import com.cos.security1.config.auth.PrincipalDetails;
import com.cos.security1.model.User;
import com.cos.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/test/login")
    public @ResponseBody String testLogin(Authentication authentication,
                                          @AuthenticationPrincipal PrincipalDetails userDetails){ // DI (의존성 주입)
        // 1. authentication 객체로 접근을 하고 PrincipalDetails 로 다운캐스팅 해서 세션 정보를 얻을 수도 있음
        // 2. @AuthenticationPrincipal 을 통해서 세션 정보를 얻을 수 있음
        System.out.println("/test/login =====================");
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        System.out.println("authentication = " + principalDetails.getUser()); // 1 번

        System.out.println("userDetails = " + userDetails.getUser()); // 2 번
        return "세션 정보 확인하기";
    }

    @GetMapping("/test/oauth/login")
    public @ResponseBody String testOauthLogin(Authentication authentication,
                                               @AuthenticationPrincipal OAuth2User oauth){ // DI (의존성 주입)
        // 1. authentication 을 PrincipalDetails 로 다운캐스팅 해서 세션 정보를 얻을 수도 있음
        // 2. @AuthenticationPrincipal 을 통해서 세션 정보를 얻을 수 있음
        System.out.println("/test/oauth/login =====================");
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println("authentication = " + oAuth2User.getAttributes()); // 1 번
        System.out.println("oAuth2User = " + oauth.getAttributes());
        return "OAuth 세션 정보 확인하기";
    }
    @GetMapping({"","/"})
    public @ResponseBody String index(){ // responseBody 사용시 뷰 리졸버 사용하지 않고 바로 http 의 body 에 문자 내용 출력 가능
        // 머스테치 기본경로 => src/main/resources/
        // 뷰리졸버 설정 => templates (prefix), .mustache (suffix) 생략 가능
        return "index";
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    // 스프링 시큐리티 해당 주소를 낚아챔 - SecurityConfig 파일 생성 후 작동 안함.
    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(User user){
        System.out.println(user);
        user.setRole("ROLE_USER");
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user); //  => 시큐리티 로그인 불가능 ( 이유 : 패스워드가 암호화가 안되어있기 때문에 )
        return "redirect:/loginForm";
    }

    @Secured("ROLE_ADMIN") // 권한 한개만 가질 때
    @GetMapping("/info")
    public @ResponseBody String info(){
        return "개인정보";
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')") // 여러 권한을 가지고 싶을때, 함수가 시작하기 전에 실행됨
    @Secured("ROLE_ADMIN")
    @GetMapping("/data")
    public @ResponseBody String data(){
        return "데이터정보";
    }


}
