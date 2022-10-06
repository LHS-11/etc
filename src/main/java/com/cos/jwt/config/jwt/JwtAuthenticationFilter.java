package com.cos.jwt.config.jwt;

import com.cos.jwt.config.auth.PrincipalDetails;
import com.cos.jwt.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

// 스프링 시큐리티에서 UsernamePasswordAuthenticationFilter 가 있음.
// /login 요청해서 username, password 전송하면 (post)
// /UsernamePasswordAuthenticationFilter 동작을 함
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    // /login 요청시 로그인 시도를 위해서 실행하는 함수 (자동으로 실행)
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        System.out.println("JwtAuthenticationFilter : 로그인 시도중");

        // 1. username, password 받아서

        try {
//            System.out.println(request.getInputStream().toString());
//
//            BufferedReader br = request.getReader();
//
//            String input=null;
//            while((input=br.readLine())!=null){
//                System.out.println( input);
//            }

            ObjectMapper om = new ObjectMapper(); // json 을 읽어옴
            User user = om.readValue(request.getInputStream(), User.class); // json 을 User 로 매핑
            System.out.println("user = " + user);

            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            // PrincipalDetailsService 가 호출 loadUserByUsername() 함수 실행된 후 정상이면 authentication 이 리턴됨
            // DB 에 있는 username 과 password 가 일치함.
            Authentication authentication = authenticationManager.authenticate(authenticationToken); // 내 로그인 정보가 담김

            // authentication 객체가 session 영역에 저장됨 => 로그인이 되었다는 뜻
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            System.out.println("로그인 완료됨 : principalDetails = " + principalDetails.getUser().getUsername()); // 값이 있으면 로그인이 정상적으로 되었음.

            // authentication 객체가 session 영역에 저장을 해야하고 그 방법은 return 해주면됨
            // 리턴의 이유 : 권한 관리를 security 가 대신 해주기 때문에 편하려고 하는것
            // 굳이 JWT 토큰을 사용하면서 세션을 만들 필요가 없음 근데 단지 권한 때문에 session 에 넣어줌
            return authentication;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 2. 정상인지 로그인 시도를 해봄 -> authenticationManager 로 시도를 하면 PrincipalDetailsService 가 호출
        // PrincipalDetailsService 가 호출 loadUserByUsername() 함수 실행됨

        // 3. PrincipalDetails 를 세션에 담고 ( 권한 관리를 위해서 )

        // 4. JWT 토큰을 만들어서 응답해주면 됨
        return null;
    }

    // attemptAuthentication 실행 후 인증이 정상적으로 되었으면 successfulAuthentication 함수가 실행
    // JWT 토큰을 만들어서 request 요청한 사용자에게 JWT 토큰을 response 해주면 됨
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        System.out.println("successfulAuthentication 실행 완료");
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
