package com.cos.security1.config.auth.ouath;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    // 구글로 부터 받은 userRequest 데이터에 대한 후처리 되는 함수
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("getClientRegistration : "+userRequest.getClientRegistration()); // registration Id 로 어떤 Oauth 로 로그인 했는지 확인 가능.
        System.out.println("getAccessToken : "+userRequest.getAccessToken());

        // 구글 로그인 버튼 클릭 -> 구글 로그인 창 -> 로그인을 완료 -> code 를 리턴 (Oauth-Client 라이브러리) -> Access Token 요청
        // userRequest 정보를 통해서 -> loadUser 함수 호출 -> 구글로부터 회원프로필 받아준다.
        System.out.println("getAttributes : "+super.loadUser(userRequest).getAttributes());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        // 회원가입을 강제로 진행해볼 예정
        return super.loadUser(userRequest);
    }

    
}
