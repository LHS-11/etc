## 서블릿 이란?
- 배경 => 처음 웹서버는 클라이언트 요청에 의해 정적 페이지만 응답 가능했음, so 웹서버에 프로그램을 붙여서 동적 페이지를 생성

- 서블릿 : 동적 페이지를 생성하기 위해 웹서버에 붙이는 프로그램

- 이점 : http 요청과 응답에 대한 파싱을 할 수고를 덜어주면서 비즈니스 로직에 집중할 수 있도록 해줌

- 서블릿으로 요청을 처리하기 위해서는 HttpServlet 를 상속하고
서비스 메서드만 정의 하면 됨
ex)
```
public class Servlet extends HttpServlet{
	
    @Override 
    protected void doGet(){
	}
}
```
- 설정 파일을 통해 어떤 요청을 받고 매핑 받을 클래스를 찾아줌

## 서블릿 컨테이너와 서블릿 동작방식
- 서블릿 컨테이너 : 서블릿의 생명주기를 관리하는 객체
=> 싱글톤 패턴으로 서블릿 인스턴스가 생성되면 재사용 

- 여러 요청이 들어오면 멀티쓰레드로 요청을 처리
=> 단점 : 쓰레드 비용 발생, Context Switch 가 많은 오버헤드 발생 시킴

- 서블릿의 단점
  - 관리적인 측면 : 멀티쓰레딩 
  - 개발적인 측면 : 핸들러 로직의 중복

## 프론트 컨트롤러 패턴
- 해결책
  - 프론트 컨트롤러 패턴을 이용해서 모든 요청을 받는 전면 컨트롤러 서블릿인 Dispatcher Servlet 을 설정 

- Dispatcher Servlet 의 역할 분담
  - Handler Mapping : 요청 처리 핸들러 검색
  - Handler Adapter : 핸들러 호출
  - View Resolver : 뷰 검색 또는 생성

## Dispatcher Servlet의 요청 처리 과정
 - 처리 과정
   - Dispatcher Servlet 이 모든 요청을 받음 
  -> Handler Mapping 이 컨트롤러를 반환 
  -> Handler Adapter 는 컨트롤러의 메서드를 호출 
  -> Dispatcher Servlet에 ModelAndView 객체 반환
  -> View Resolver로 View 탐색

## Spring Container
=> Dispatcher Servlet 이 스프링 컨테이너로부터 주입을 받아서 Handler Mapping, Handler Adapter, View Resolver 처리를 해주고 개발자는 핸들러(컨트롤러)만 신경쓰면 됨!!


- 스프링 컨테이너 안에는 

> Dispatcher Servlet 
=> Servlet WebApplicationContext (웹 요청 처리 관련 객체) + Root WebApplicationContext (서비스, 레포지토리 관련 객체)

이런식으로 존재 -> **이 부분에서 디스패처 서블릿이 요청을 처리할 때 필요한 부분을 알아서 주입해줌**








