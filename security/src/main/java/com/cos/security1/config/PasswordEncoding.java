package com.cos.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoding {

    @Bean // 해당 메서드로 리턴되는 IOC 로 등록해줌
    public BCryptPasswordEncoder encoderPwd(){
        return new BCryptPasswordEncoder();
    } // 비밀번호 암호화
}
