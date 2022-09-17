스프링 시큐리티

자기만의 시큐리티 세션 들고 있음

서버 자체의 session (안에 시큐리티가 관리하는 시큐리티 session 이 존재)

시큐리티 세션에서 들어올 수 있는 타입은 Authentication 객체 ( controller 에서 DI 가능)

Authentication
1) UserDetails -> 일반적인 로그인
2) Oauth2User -> OAuth 로그인 (구글, 네이버 등)
=> 위 두 개를 PrincipalDetails 타입으로 묶어버리면 그냥 PrincipalDetails 공통적으로 사용하면 됨

