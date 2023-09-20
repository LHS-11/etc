package com.cos.security1.config.auth.ouath.provider;

public interface OAuth2UserInfo {

    String getProviderId(); // 페이스북

    String getProvider(); // 구글

    String getEmail();

    String getName();
}
