## Spring 이란?
=> Spring Framework, Spring Boot, Spring Data 등등 여러 프로젝트들의 모음

- Spring 은 웹 개발 뿐 아니라 다양한 일을 할 수 있음 ( Microservices, Reactive 등)
- 프로젝트 별로 하위 프로젝트 (모듈)을 가지고 있음
ex) Spring -> SpringBoot -> Spring JDBC, Spring AOP 등

- 스프링 프로젝트 => 스프링 프레임워크 기반으로 실행
ex) Spring JDBC, Spring JPA 를 사용하기 위해서는 스프링 프레임워크를 사용해야함 

## Spring Framework 란?
=> 객체지향 언어가 가진 특징을 잘 활용하게 해주면서 개발자가 비즈니스 로직에만 집중하게 해줌 
(인프라 지원을 해준다 => 특정 배포 환경이나 여러 환경설정을 지원)

=> 비즈니스 로직과 엔터프라이즈 기술을 분리해서 Spring Framework 가 엔터프라이즈 기술을 지원함으로써 개발자는 비즈니스 로직에만 집중 가능

## Spring Framework 가 나온 이유?
=> Spring 의 경우 설정이 많아지고 복잡해지면서 설정을 하는데 어려움을 겪음 

- SpringBoot 는 Spring 프로젝트 중 하나로 Spring Framework 를 쉽게 사용할 수 있게 해주는 도구일 뿐 별개로 사용할 순 없다.

## Spring Boot 를 사용하면 달라지는 점
- 의존성 관리
	기존 Spring의 경우 개발에 필요한 모듈의 의존성을 다운로드 하고
    각 모듈의 버전을 개발자가 하나하나 명시해줘야 함
    => SpringBoot는 spring-boot-starter 모듈을 통해 문제 해결
    => spring-boot-starter-parent : 각 모듈의 현재 Spring Boot 에 적합한 버전을 제공

- 자동 설정
	기존 Spring 의 경우 Bean 에 등록, View 설정 다 해줘야함
    => SpringBoot는 의존성을 추가하고 application.yml 파일에 설정만 해주면 자동으로 다 설정 해줌
    
- 내장 WAS
	기존 Spring 의 경우 
    1) 애플리케이션 WAR 패키징
    2) WAS 설치 (Tomcat, Jetty 등) 
    3) WAS에 WAR 파일 올리기
    => Spring Boot는 WAS가 내장되어 있음 (디폴트는 톰캣, 의존성을 통해 제티로 변경 가능)
    => war, jar 패키징 둘다 가능
    
- 모니터링
	SpringBoot 의 모듈 중 하나인 'Actuator' 는 애플리케이션의 관리 및 모니터링을 지원 
    ('Actuator'는 상용 서비스 수준에서 필요로 할 모니터링 기능을 엔드포인트로 미리 만들어서 제공)




-----------------------------------------------------
우아한Tech의 테코톡(에어의 Spring vs Spring boot)를 참조하였습니다.
