package com.cos.security1.config.auth;



import com.cos.security1.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

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

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return null;
    }


}
