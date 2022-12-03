# Chapter 1 UML
## 모델링이란? 
=> 모델화 (추상화) 하는것
### 모델이란?
- 서로의 해석을 공유해 합의를 이루거나 **해석의 타당성을 검토하기 위함**
- 개발할 소프트웨어의 원하는 모습을 **가시화하기 위함**
- 시스템의 구조와 행위를 **문서화, 틀 제공**

## UML 이란?
=> _요구 분석, 시스템 설계, 시스템 구현_ 등의 시스템 개발 과정에서 개발자 사이의 **의사소통이 원활히 이루어지도록 표준화한 통합 모델링 언어**

### UML 다이어그램의 종류
- 구조 다이어그램
  - **클래스 다이어그램** : 변하지 않는 **시스템의 정적인 면**을 보여주는 대표적인 UML 구조 다이어그램
  - 객체 다이어그램
  - 복합체 구조 다이어그램
  - 배치 다이어그램
  - 컴포넌트 다이어그램
  - 패키지 다이어그램

- 행위 다이어그램
  - 활동 다이어그램
  - 상태 머신 다이어그램
  - 유즈 케이스 다이어그램
  - 상호작용 다이어그램
    - 순차 다이어그램
    - 상호작용 개요 다이어그램
    - 통신 다이어그램
    - 타이밍 다이어그램

### 클래스란?
=> **동일한 속성과 행위를 수행하는 객체의 집단** ( 저자는 클래스가 변화의 기본 단위라고 표현 )

#### 접근 제어자
- public (+) : 어떤 클래스의 객체에서든 접근 가능
- private (-) : 이 클래스에서 생성된 객체들만 접근 가능
- protected (#) : 이 클래스와 동일 패키지에 있거나 상속 관계에 있는 하위 클래스의 객체들만 접근 가능
- package (~) : 동일 패키지에 있는 클래스의 객체들만 접근 가능

### 관계
- 연관 관계 : 클래스들이 개념상 서로 연결되어 있음 ( 화살표로 표시하며 보통 한 클래스가 다른 클래스에서 제공하는 기능 사용할 때 표시)
- 일반화 관계 (상속 관계) : 한 클래스가 다른 클래스를 포함하는 상위 개념 (속이 빈 화살표)
- 집합 관계 : 클래스들 사이의 전체 또는 부분 같은 관계 
  - 집약 관계 : 전체 객체의 라이프타임과 부분 객체의 라이프타임은 독립적 ( 전체 객체가 메모리가 사라진다 해도 부분 객체는 사라지지 않음 )
  - 합성 관계 : 부분 객체의 라이프타임은 전체 객체의 라이프타임에 독립적 ( 전체 객체가 없어지면 부분 객체도 없어짐 )
- 의존 관계 : 연관 관계와 같이 한 클래스가 다른 클래스에 제공하는 기능을 사용할 때, 차이점은 관계가 메서드를 실행하는 동안만 유지됨
  - 연산의 인자
  - 메서드의 지역 객체로 참조
- 실체화 관계 : 책임들의 집합인 인터페이서와 이 책임들을 실제로 실현한 클래스들 사이의 관계

-------------------------------------------------------------------------------------------------------
# Chapter 2 객체지향 원리
## 1. 추상화란?
=> 어떤 영역에서 필요로 하는 속성이나 행동을 추출하는 작업을 의미 (특정 절차나 물체를 의도적으로 생략하거나 감춤)

## 2. 캡슐화란?
=> 낮은 결합도를 유지할 수 있도록 해주는 객체지향 설계 원리

=> 정보 은닉(private) 을 통해 **높은 응집도와 낮은 결합도**를 가지게 함

### 응집도
=> 클래스나 모듈 안의 요소들이 *얼마나 밀접*하게 관련되어 있는지를 나타냄
=> 메서드가 변수를 더 많이 사용 할수록 메서드와 클래스는 응집도가 더 높음
=> 응집도를 유지하려면 작은 클래스가 여럿 나옴

### 결합도
=> 어떤 기능을 수행하는 데 다른 클래스나 모듈들에 얼마나 의존적인지를 나타냄

=> 높은 결합도를 가질 수록 변경이 생겼을 때 영향을 많이 받음 so 낮은 결합도를 유지해야함

**높은 응집도와 낮은 결합도를 유지할 수 있도록 설계 해야함**

## 3. 일반화 (상속 관계)
=> 여러 개체들이 가진 공통된 특성을 부각시켜 하나의 개념이나 법칙으로 성립시키는 과정

=> 외부 세계에 자식 클래스를 캡슐화하는 과정

**일부 기능만 재사용하고 싶은 경우에는 어떻게 하는 것이 좋을까?**

=> **위임**을 사용! (자신이 직접 기능을 실행하지 않고 다른 클래스의 객체가 기능을 실행하도록 위임하는 것)

=> 일반화 관계는 클래스 사이의 관계 but 위임은 객체 사이의 관계

ex)
```
public class MyStack<String> extends ArrayList<String> {

  public void push(String e){
  add(e);
  }

  public String pop(){
  return remove(size() - 1);
  }
 }
```

위임 사용시
```
public class MyStack<String>  {

    private ArrayList<String> arrayList = new ArrayList<String>();
    
    public void push(String e){
        arrayList.add(e);
    }
    
    public String pop(){
        return arrayList.remove(size() - 1);
    }
    
    public boolean isEmpty(){
        return arrayList.isEmpty();
    }
    
    public int size(){
        return arrayList.size();
    }
}
```

## 4. 다형성이란?
=> 서로 다른 클래스의 객체가 같은 메시지를 받았을 때 각자의 방식으로 동작하는 능력

=> 자식 클래스를 개별적으로 다룰 필요 없이 한 번에 처리할 수 있게 하는 수단을 제공

=> 일반화 관계에 있을 때 부모 클래스의 참조변수가 자식 클래스의 객체를 참조 가능 

(단, 부모 클래스의 참조 변수가 접근할 수 있는 것은 부모 클래스가 물려준 변수와 메서드만)

## 피터 코드의 상속 규칙
- 자식 클래스와 부모 클래스 사이는 '역할 수행' 관계가 아니어야 함
- 한 클래스의 인스턴스는 다른 서브 클래스의 객체로 변환할 필요 X
- 자식 클래스가 부모 클래스의 책임을 무시하거나 재정의하지 않고 확장만 수행해야 함
- 자식 클래스가 단지 일부 기능을 재사용할 목적으로 유틸리티 역할을 수행하는 클래스를 상속하지 않아야 함
- 자식 클래스가 '역할', '트랜잭션', '디바이스' 등을 특수화 해야 함

**정적 메서드는 상속을 통해 오버라이드 되지 않음 정적 메서드를 실행할 때 동적 바인딩을 실행하는 것이 아니고 컴파일할 때 결정된 객체의 타입에 따라 실행될 메서드가 결정**

----------------------------------------------------------------------------------

# Chapter3 SOLID 원칙
## 1. 단일 책임 원칙 (SRP => Single Responsibility Principle)
=> 객체는 하나의 책임만 가져야 함

### 책임이란?
=> '해야 하는 것' 이나 '할 수 있는 것', '해야 하는 것을 잘할 수 있는 것'

### 설계 원칙을 학습하는 이유
=> 예측하지 못한 변경사항이 발생하더라도 유연하고 확장성이 있도록 시스템 구조를 설계하기 위함

### 좋은 설계란?
=> 기본적으로 시스템에 새로운 요구사항이나 변경이 있을 때 가능한 한 영향 받는 부분을 줄여야 함

=> 어떤 클래스가 잘 설계 되었는지를 판단하려면 언제 변경되어야 하는지를 보면 됨

책임을 많이 질수록 클래스 내부에서 서로 다른 역할을 수행하는 코드끼리 강하게 결합될 가능성 높아짐

### 책임 분리
=> 책임이 많다면 한 클래스에서 변경 사항이 생겼을 때 그 클래스를 사용하는 다른 코드도 회귀 테스트를 진행 해야함

### 회귀 테스트
=> 시스템에 변경이 발생할 때 기존의 기능에 영향을 주는지를 평가하는 테스트

### 산탄총 수술
=> 하나의 책임이 여러 개의 클래스들로 분산되어 있는 경우에도 단일 책임 원칙에 입각해 설계를 변경해야함

=> 어떤 변경이 있을 때, 여러 클래스를 변경해야함

### 횡단 관심
=> 로깅, 보안, 트랜잭션 등 (부가 기능)

=> 횡단 관심이 여러 주요 로직들과 같이 있을 때, 수정사항이 생기면 변경하기 어려움

   -> 부가 기능을 별개의 클래스로 분리해 책임을 담당하게 함 ( 여러 곳에 흩어진 공통 책임을 한 곳에 모으면서 응집도를 높임 )

### AOP
=> 횡단 관심 문제를 해결하는 관심지향 프로그래밍

=> 횡단 관심을 수행하는 코드를 애스팩트라는 특별한 객체로 모듈화하고 위빙이라는 작업을 통해 모듈화한 코드를 핵심 기능에 끼워넣을 수 있음

=> 횡단 관심에 변경이 생길 시 Aspect 만 수정

## 2. 개방-폐쇄 원칙 (OCP => Open-Closed Principle)
=> 기존의 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계

=> 클래스를 변경하지 않고도 대상 클래스의 환경을 변경할 수 있는 설계

ex) 데이터베이스를 사용하는 기능을 테스트 할 때 데이터베이스 기능을 대체하는 가짜 객체를 만들어 테스트

### OCP 를 위반하지 않은 설계를 할 때 중요한 것
=> 무엇이 변하는 것인지, 무엇이 변하지 않은 것인지를 구분 해야함

### OCP 를 수행하기 위해서는
=> 개별적인 클래스를 직접 처리하지 않고, 인터페이스에서 구체적인 매체를 캡슐화해 처리해야함

## 3. 리스코프 치환 원칙 (LSP)
=> 자식 클래스는 최소한 자신의 부모 클래스에서 가능한 행위를 수행할 수 있어야 함

=> 부모 클래스의 인스턴스를 자식 클래스의 인스턴스로 대체해도 프로그램의 의미는 변화X

=> 슈퍼 클래스에서 상속 받은 메서드들이 서브 클래스에 오버라이드, 즉 재정의되지 않도록 해야 함

## 4. 의존 역전 원칙 (Dependency Inversion Principle)
=> 자주 변화하는 것 (구체적) 보단 변화하기 어려운 것, 거의 변화가 없는 것(추상적) 의존 

=> 인터페이스나 추상 클래스에 의존 관계를 맺도록 설계

### 의존성 주입 (Dependency Injection)
=> 클래스 외부에서 의존되는 것을 대상 객체의 인스턴스 변수에 주입하는 기술 

## 5. 인터페이스 분리 원칙
=> 클라이언트 자신이 이용하지 않는 기능에는 영향을 받지 않아야 함

=> 인터페이스를 클라이언트에 특화되도록 분리시키라는 설계 원칙

ex) 복합기 라는 클래스에 복사, 팩스, 프린트 하는 기능이 있을 때

각각 interface 를 나눠서 interface 가 일종의 방화벽 역할을 수행해 클라이언트는 자신이 사용하지 않는 메서드에 생긴 변화로 인한 영향을 안받음

-----------------------------------------------------------------------------------------------
# Chapter 4 디자인 패턴
## 패턴이란?
=> 각 패턴은 우리 주변에서 자주 반복해서 발생하는 문제와 그 문제를 해결하는 핵심을 기술해 동일한 일을 두 번 다시 하지 않고 해결할 수 있도록 함

=> 해결책 사이의 공통점

### 디자인 패턴 구조
- 콘텍스트 : 문제가 발생하는 여러 상황 ( 패턴이 적용될 수 있는 상황 )
- 문제 : 패턴이 적용되어 해결될 필요가 있는 여러 디자인 이슈들 기술
- 해결 : 문제를 해결하도록 설계를 구성하는 요소들과 그 요소들 사이의 관계, 책임, 협력 관계를 기술 ( 다양한 상황에 적용할 수 있는 일종의 템플릿 )

### 패턴
- 아키텍처 패턴 : 시스템을 구성하는 컴포넌트의 구성과 컴포넌트 사이의 협조 방법을 패턴화 한 것
- 디자인 패턴 : 아키텍처 패턴에서 컴퍼넌트의 내부 구조를 대상으로 한 클래스 /객체의 구조와 협업 방법을 패턴화한 것
- 관용구 : 각각의 프로그램 언어 특유의 패턴, 프로그래밍에서 자주 사용하는 기술 방법을 패턴화한 것

## GoF 디자인 패턴
- 생성 패턴 : 객체 생성에 관련된 패턴
  - 추상 팩토리
  - 빌더
  - 팩토리 메서드
  - 프로토타입
  - 싱글톤
- 구조 패턴 : 클래스나 객체를 조합해 더 큰 구조를 만드는 패턴
  - 어댑터
  - 브리지
  - 컴퍼지트
  - 데커레이터
  - 퍼사드
  - 플라이웨이트
  - 프록시
- 행위 패턴 : 객체나 클래스 사이의 알고리즘이나 책임 분배에 관련된 패턴, 결합도를 최소화하는 것에 중점
  - 책임 연쇄
  - 커맨드
  - 인터프리터
  - 이터레이터
  - 미디에이터
  - 메멘토
  - 옵서버
  - 스테이트
  - 스트래티지
  - 탬플릿 메서드
  - 비지터

### 생성 패턴
- 추상 팩토리 : 구체적인 클래스에 의존하지 않고 서로 연관되거나 의존적인 객체들의 조합을 만드는 인터페이스를 제공하는 패턴
- 팩토리 메서드 : 객체 생성 처리를 서브 클래스로 분리해 처리하도록 캡슐화 하는 패턴
- 싱글톤 : 전역 변수를 사용하지 않고 객체를 하나만  생성하도록 하며, 생성된 객체를 어디에서든 참조할 수 있도록 하는 패턴

### 구조 패턴
- 컴퍼지트 : 여러 개의 객체들로 구성된 복합 객체와 단일 객체를 클라이언트에서 구별 없이 다루게 하는 패턴
- 데커레이터 : 객체의 결합을 통해 기능을 동적으로 유연하게 확장할 수 있게 해주는 패턴

### 행위 패턴
- 옵서버 : 한 객체의 상태 변화에 따라 다른 객체의 상태도 연동되도록 일대다 객체 의존 관계를 구성하는 패턴
- 스테이트 : 객체의 상태에 따라 객체의 행위 내용을 변경해주는 패턴
- 스트래티지 : 행위를 클래스로 캡슐화해 동적으로 행위를 자유롭게 바꿀 수 있게 해주는 패턴
- 템플릿 메서드 : 어떤 작업을 처리하는 일부분을 서브 클래스로 캡슐화해 전체 일을 수행하는 구조는 바꾸지 않으면서 특정 단계에서 수행하는 내역을 바꾸는 패턴
- 커맨드 : 실행될 기능을 캡슐화함으로써 주어진 여러 기능을 실행할 수 있는 재사용이 높은 클래스를 설계하는 패턴
 
## UML
- 구조적인 면 : 컬레보레이션
  - 컬레보레이션 : 객체들이 특정 상황에서 수행하는 역할의 상호작용의 요소
- 행위적인 면 : 순차 다이어그램 
  - 순차 다이어그램 : 객체들 사이의 메시지 송신과 그들의 순서를 나타냄 

### 순차 다이어그램 
- 생명선 : 객체 아래에 점섬으로 뻗어 가며, 해당 객체가 존재함을 의미
- 활성구간 : 생명선을 따라서 좁고 긴 직사각형, 색체가 연산을 실행하는 상태임
- 비동기 메시지 : 머리 부분이 채워지지 않고 열려있는 화살표, 메시지를 송신한 후 메시지 실행이 끝나기를 기다리지 않고 다음 작업을 바로 수행
- 동기 메시지 : 머리 부분이 채워진 화살표, 메시지의 실행을 요청하는 객체가 메시지의 실행이 종료될 떄까지 다음 작업을 수행 X

-----------------------------------------------------------------
# 스트래티지 패턴
=> 전략(일을 수행하는 방식, 알고리즘, 비즈니스 규칙)을 쉽게 바꿀 수 있도록 해주는 디자인 패턴

## 스트래티지 패턴이 나오게 된 이유

### 문제점 
- 기존 로봇의 공격 또는 이동 방법을 수정하고 싶음

=> 해당 로봇의 클래스의 메서드를 수정해야함 -> OCP 위반

- 새로운 로봇을 만들어 기존의 공격 또는 이동 방법을 추가하거나 수정하고 싶음

=> 새로운 로봇 클래스를 만들고 기존의 공격 또는 이동 메서드를 추가하면 됨 -> 중복 메서드를 사용해 중복 코드 발생 

- 새로운 방식의 이동 기능과 공격 기능을 로봇에게 제공하려면 기존의 이동, 공격 메서드들을 수정해야함 

=> 이러한 행위는 프로그램에 오류가 발생시키는 상황이 될 수 있음

### 해결책
=> 변화된 것을 찾아서 이를 클래스로 캡슐화 시켜야 함

=> 변화된 것 -> **(이동 방식이나 공격 방식)** 은 새롭게 추가되거나 재사용 해야할 수 있다

=> 구체적인 이동 방식과 공격 방식을 담은 구체적인 클래스들은 은닉하고 이를 위해 공격과 이동을 위한 인터페이스를 만들고 이들을 실제

실현한 클래스를 만들어야 함

---------------------------------------------------------------------------------------------------------------

# Chapter 6 싱글톤 패턴
## 싱글톤 패턴
=> 두 개 이상의 인스턴스가 생기는 것을 막고 인스턴스가 사용될 때에는 동일 인스턴스를 사용하게 하는 것

ex) 회사에 프린터가 하나만 있을 때 직원 여러명이 그 프린터 하나만을 공유해서 사용해야함 

=> 처음에 객체를 생성해 이를 어디에서든 참조 가능하도록 해야함 

=> 정적변수 instance 를 선언하고, 정적 메서드 getInstance 를 선언해 Printer.getInstance() 를 통해 객체를 만들어서 그 객체만 사용하도록 함

-> 다중 쓰레드에서 문제가 생김

### 두가지 해결책
- 정적 변수에 인스턴스를 만들어 바로 초기화 하는 방법
  - => 정적 변수는 객체가 생성되기 전 클래스가 메모리에 로딩될 때 만들어져 초기화가 한 번만 실행됨, 
  - 프로그램이 시작될 때부터 종료될 때까지 없어지지 않고 메모리에 상주하며 클래스에서 생성된 모든 객체에서 참조 가능
- 인스턴스를 만드는 메서드에 동기화하는 방법
  - => synchronized 메서드를 동기화하여 여러 쓰레드가 접근하는 것을 방지


## static 메서드, 변수
=> 구체적인 인스턴스에 속하는 영역이 아니고 클래스 자체에 속함

=> 클래스의 인스턴스롤 통하지 않고서도 메서드를 실행할 수 있고 변수를 참조할 수 있다.

### 정적 클래스(정적 메서드로만 이루어진 클래스) 와 싱글턴 패턴을 이용하는 방법의 차이점
=> 객체를 전혀 생성하지 않고 메서드를 사용, 정적 메서드를 사용하는 것이 바인딩되는 인스턴스 메서드를 사용하는 것보다 성능적으로 더 우수

--------------------------------------------------------------------------------
## Thread (쓰레드)
=> 프로그램을 실행하고 있는 주체

=> 그냥 코드 실행시 **싱글 쓰레드** 프로그램 (자바 프로그램 실행시 적어도 하나의 쓰레드가 움직임)

#### 밖에서 움직이는 쓰레드
- 가비지콜렉션 (garbage collection)
- GUI 관련 쓰레드 

### 멀티 쓰레드 프로그램 
=> 복수의 쓰레드가 동작

#### Thread 클래스의 run 메서드와 start 메서드
```
public class MyThread extends Thread{

    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.println("Nice!");
        }
    }
}
```
=> 새롭게 사용되는 쓰레드의 동작을 run() 메서드에 기술

```
public class Main {

    public static void main(String[] args) {

        Thread myThread = new MyThread();

        myThread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.print("Good!");
        }
    }
}
```
=> Thread 객체를 만들고, **start() 메서드**를 사용하면 새로운 쓰레드가 기동됨

=> 이 때 메인쓰레드는 두 개의 작업을 하고 있음

1. Nice!를 표시하는 새로운 쓰레드의 기동
2. Good! 표시

=>
```
Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!
Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!Nice!
Nice!Nice!Nice!Nice!Nice!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!
Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!Good!
.....
```
=> Good 과 Nice 가 번갈아서 출력됨

=> 두 개의 쓰레드가 일을 분담함
1. 메인 쓰레드는 Good!이라는 문자열 표시
2. 새롭게 기동된 쓰레드는 Nice!라는 문자열 표시

#### 병행과 병렬
=> 병행은 시분할처럼 번갈아 가면서 실행 하는 것

=> 병렬은 같은 시간에 동시에 실행 되는 것 ( 여러개의 프로세서를 가진 컴퓨터라면 가능 )

### 쓰레드 기동하는 방법 1 => Thread 클래스의 서브 클래스를 사용
```
public class PrintThread extends Thread {

    private String msg;

    public PrintThread(String msg){
        this.msg = msg;
    }

    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.print(msg);
        }
    }

}
public class Main {

    public static void main(String[] args) {

        new PrintThread("Good!").start();
        new PrintThread("Nice!").start();
    }
}
```
=> 이 때, PrinterThread 인스턴스를 만드는 것과 쓰레드를 기동하는 것은 별개이다 

=> 인스턴스를 만들어도 start 메서드를 부르기 전까지 쓰레드는 기동되지 않음

### 쓰레드를 기동하는 방법 2 => Runnable 인터페이스를 사용
```
public class PrintThread implements Runnable{

    private String msg;

    public PrintThread(String msg){
        this.msg = msg;
    }

    public void run(){
        for (int i = 0; i < 1000; i++) {
            System.out.print(msg);
        }
    }

}
public class Main {

    public static void main(String[] args) {

        new Thread(new PrintThread("Good!")).start();
        new Thread(new PrintThread("Nice")).start();
    }
}
```
=> 1,2 번째 방법도 쓰레드를 기동하는 방법은 Thread 클래스의 **start 메서드**를 사용 해야함

### 쓰레드의 일시정지
- Thread.sleep(1000) => 1밀리초 * 1000 = 1초
  - => 이 쓰레드 함수 사용시 이 문장을 실행한 쓰레드가 1초 동안 일시정지함 
- sleep 메서드의 호출은 try-catch 로 둘러싸여 있음 ( sleep 메서드가 InterruptException 이라고 하는 예외롤 벗어나야 할 경우가 있기 때문) 

### 쓰레드의 배타 제어
=> 어떤 부분이 실행하고 있으면 다른 쓰레드는 그 부분을 실행할 수 없도록 함 (교통 정리)

=> synchronized 키워드 사용 (동기 메서드) -> 락이 걸림

=> 어떤 인스턴스에 관한 synchronized 메서드는 한번에 하나의 쓰레드 밖에 실행할 수 없음

=> 각각의 쓰레드가 synchronized 라는 키워드가 붙은 메서드를 각각 실행 X (락을 걸어둠)

=> 쓰레드가 그 메서드의 실행이 끝나면 락이 해제

### synchronized 블록
=> 메서드의 일부를 하나의 쓰레드로 동작하게 하고 싶은 경우
```
synchronized void method(){
  ...
}

void method(){
    synchronized(this){
        ...
    }
}
```
=> 위 두개는 기능적으로 같음, 사용하는 락이 서로 다름

#### synchronized 클래스 메서드와 synchronized 블록
```
class Something{
    static synchronized void method(){
         ...
    }
}

class Something{
    static void method(){
        synchronized(this){
      
        }
    }
}
```
=> synchronized 한 인스턴스 메서드에서는 쓰레드의 배타제어를 위해 this 락이 사용됨

=> synchronized 한 클래스 메서드에서는 쓰레드의 베타제어를 위해 그 클래스의 클래스 객체 락이 사용됨

### 쓰레드의 협조 (복잡한 베타제어)
- 영역이 비어 있으면 데이터를 써넣지만 비어 있지 않으면 빌 때까지 기다림 -> wait
- 영역이 비어 있으니 기다리고 있는 쓰레드에 비어있는 것을 알림 -> notify, notifyAll

#### wait 셋 - 쓰레드의 대합실
- 인스턴스 wait 메서드를 실행한 후 동작을 정지하고 있는 쓰레드의 집합
- wait 메서드 실행시 동작을 일시 정지하고 wait 셋이라고 하는 대합실에 들어감 
  - 다른 쓰레드에서 notify 메서드에 의해 일어남
  - 다른 쓰레드에서 notifyAll 메서드에 의해 일어남  
  - 다른 쓰레드에서 interrupt 메서드에 의해 일어남
  - wait 메서드가 타임아웃됨
- wait 메서드를 실행하기 위해서는 쓰레드가 락을 가지고 있어야 함 => wait 셋에 들어가기 전에 락을 해제하고 들어감
- 락을 가지고 있지 않은 쓰레드가 wait, notify, notifyAll 메서드 실행시 Exception 터짐

-------------------------------------------------------------------
# Chapter 7 스테이트 패턴
## 스테이트 패턴이 나오게 된 계기
실세계의 많은 시스템은 다양한 상태가 있고 동일한 자극에 대해 상태에 따라 다른 행위를 함

자신이 처한 상태에 따라 일을 다르게 수행할 때의 상태에 따라 상태 하나하나가 어떤 상태인지 검사해 일을 다르게 수행하게끔 하는 것

=> 복잡한 조건식이 있는 코드를 산출, 코드를 이해하거나 수정하기 어려움

## 스테이트 패턴
=> 어떤 행위를 수행할 때 상태에 행위를 수행하도록 위임함

=> 시스템의 각 상태를 클래스로 분리해 표현하고, 각 클래스에서 수행하는 행위들을 메서드로 구현

=> 이러한 상태들을 외부로부터 캡슐화하기 위해 인터페이스를 만들어 시스템의 각 상태를 나타내는 클래스로 하여금 실체화 함

### 문제점
=> 새로운 상태를 추가 할 때 기존의 조건문에서는 코드를 변경해서 OCP 를 위반하게 됨

=> 상태 진입이 복잡한 조건문에 내포된 현재 코드는 시스템의 상태 변화를 파악하기 용이하지 않음

그래서 새로운 상태가 추가되는 경우에 상태 변화를 초래하는 모든 메서드에 이를 반영하기 위한 코드를 수정해야함

### 해결책
=> 변하는 부분을 찾아서 캡슐화 (상태를 인터페이스로 생성)

-> 상태 변화가 생길 때마다 새로운 상태 객체를 생성해 메모리 낭비와 성능 저하를 가져올 수 있음

-> 싱글톤 패턴을 사용해 해결
![image](https://user-images.githubusercontent.com/77667212/205425656-141d618a-9892-49e0-a082-9622903578ca.png)

### 스테이트 패턴의 컬레보레이션
- State (State) : 시스템의 모든 상태에 공통된 인터페이스를 제공 -> 이 인터페이스를 실체화한 어떤 상태 클래스도 기존 상태 클래스를 대신해 교체 가능

- State1,2,3 (ON,OFF) : Context 객체가 요청한 작업을 자신의 방식으로 실제 실행, 대부분의 경우 다음 상태를 결정해 상태 변경을 Context 객체에 요청하는 역할도 수행

- Context (Light) : State 를 이용하는 역할을 수행, 현재 시스템의 상태를 나타내는 상태 변수와 실제 시스템의 상태를 구성하는 여러가지 변수가 존재 또한 각 상태 클래스에서 상태 변경을 요청해 상태를 바꿀 수 있도록 하는 메서드가 제공됨

### 장점과 단점
#### 장점
- 상태에 대한 모든 행동양식이 한 곳에 있어 유지보수하기 편리함
- 메서드 상의 분기문들을 제거 가능
#### 단점
- 클래스 갯수가 많아져서 오히려 유지보수가 힘들 수도 있음
- 상태에 따라 변하는 메서드의 숫자가 적다면 오히려 불필요한 복잡성을 추가할수도 있음

### 스테이트 패턴과 스트래티지 패턴
- 공통점 : 
  - 행위 자체를 별도의 클래스로 캡슐화하고, 연관 관계를 이용해 행위를 캡슐화한 클래스
  - 실제 작업 수행을 위임하는 측면에서 동일
  - 실행 중에 행위를 변경 가능
  
- 차이점 :
  - 스테이트 패턴에서 클라이언트는 상태 객체와 관련된 어떤 지식도 없음.
  - 스테이트 패턴에서는 행위가 자주 변경
  - 스트래티지 패턴에서는 Context 요소에서 행위(전략)가 한번 고정되면 자주 변경 X ,행위를 변경하는 주체가 스트이트 패턴과 다름

--------------------------------------------------------
# Chapter 8 커맨드 패턴
## 커맨드 패턴
=> 이벤트가 발생했을 때 실행될 기능이 다양하면서도 변경이 필요한 경우에 이벤트를 발생시키는 클래스를 변경하지 않고 재사용하고자 할 때 유용하게 사용

### 문제점
- 누군가 버튼을 눌렀을 때 램프가 켜지는 대신 다른 기능을 싈행하게 하려면 어떤 변경 작업을 해야 하는가?

ex) 버튼을 눌렀을 때 알람 시작

- 버튼을 누르는 동작에 따라 다른 기능을 실행하게 하려면 어떤 변경 작업을 해야 하는가? 

ex) 버튼 처음 눌렀을 때 램프 켜짐, 두 번 눌렀을 때 알람 동작

### 해결책
- 구체적인 기능을 직접 구현하는 대신 실행될 기능을 클래스 외부에서 제공받아 캡슐화해 실행 메서드에서 호출

### 커맨드 패턴의 컬레보레이션
- Command : 실행될 기능에 대한 인터페이스, 실행될 기능을 execute 메서드로 선언
- ConcreteCommand : 실제로 실행되는 기능을 구현 (Command 인터페이시를 구현)
- Invoker : 기능의 실행을 요청하는 호출자 클래스
- Receiver : ConcreteCommand 에서 execute 메서드를 구현할 때 필요한 클래스 ( Concrete Command 의 기능을 실행하기 위해 사용하는 수신자 클래스 )

# Chapter 9 옵서버 패턴
## 옵저버 패턴
=> 데이터의 변경이 발생했을 경우 상대 클래스나 객체에 의존하지 않으면서 데이터 변경을 통보하고자 할 때 유용한 패턴 

ex) 탐색기 => 새로운 파일이 추가되거나 삭제되었을 때 탐색기는 바로 update 해야함

### 문제점 
- 성적을 다른 형태로 출력하고 싶다면 어떤 변경 작업을 해야할까?

ex) 성적을 목록으로 출력하지 않고 최소/최대 값만 출력하려면?

- 여러 가지 형태의 성적을 동시 혹은 순차적으로 출력하려면 어떤 변경 작업을 해야 하는가?

ex) 성적이 입력되었을 때 최대 3개 목록, 최대 5개 목록, 최소/최대 값을 동시에 출력하거나 처음에는 목록으로 출력하고 나중에는 최소/최대 값을 출력하려면?

### 해결책
- ScoreRecord 클래스에서는 통보 대상인 객체를 참조하는 것을 관리해야 하며 addScore 메서드에서 각 통보 대상인 객체의 update 메서드를 호출해야함

=> 공통 기능을 상위 클래스 및 인터페이스로 일반화하고 이를 활용해 ScoreRecord 를 구현하는 방식으로 설계

### 옵저버 패턴의 컬레보레이션
- Subject : ConcreteObserver 객체를 관리하는 요소, Observer 인터페이스를 참조해서 ConcreteObserver 를 관리하므로 ConcreteObserver 의 변화에 독립적
- ConcreteSubject : 변경 관리 대상이 되는 데이터가 있는 클래스, 데이터 변경을 위한 메서드인 setState 가 있으며 setState 에서는 자신의 데이터인 subjectState 를 변경하고 Subject 의 notifyObservers 메서드를 호출해서 ConcreteObserver 객체에 변경을 통보함.
- Observer : 데이터의 변경을 통보 받는 인터페이스, Subject 에서는 Observer 인터페이스의 update 메서드를 호출함으로써 ConcreteSubject 의 데이터 변경을 ConcreteObserver 에게 통보함
- ConcreteObserver : ConcreteSubject 의 변경을 통보받는 클래스, Observer 인터페이스의 update 메서드를 구현함으로써 변경을 통보, 변경된 데이터는 ConcreteSubject 의 getState 메서드를 호출함으로써 변경을 조회

# Chapter 10 데커레이터 패턴
## 데커레이터 패턴
=> 기본 기능에 추가할 수 있는 기능의 종류가 많은 경우에 각 추가 기능을 Decorator 클래스로 정의한 후 필요한 Decorator 객체를 조합함으로써 
추가 기능의 조합을 설계하는 방식

### 문제점
- 또 다른 도시 표시 기능을 추가로 구현하고 싶다면 어떻게 해야할까?
ex) 기본 도로 표시에 교통량을 표시
- 여러 가지 추가 기능을 조합해 제공하고 싶다면 어떻게 해야할까?
ex) 기본 도로 표시에 차선 표시 기능과 교통량 표시 기능 추가 

### 해결책 
=> 각 추가 기능별로 개별적인 클래스를 설계하고 기능을 조합할 때 각 클래스의 객체 조합을 이용하면 됨

### 데커레이터 패턴의 컬래보레이션
- Component : 기본 기능을 뜻하는 ConcreteComponent 와 추가 기능을 뜻하는 Decorator 의 공통 기능을 정의
- ConcreteComponent : 기본 기능을 구현하는 클래스
- Decorator : 많은 수가 존재하는 구체적인 Decorator 의 공통 기능을 제공
- ConcreteDecorator : Decorator 의 하위 클래스로 기본 기능에 추가 되는 개별적인 기능을 뜻함

# Chapter 11 템플릿 메서드 패턴
## 템플릿 매서드 패턴
=> 전체적으로는 동일하면서 부분적으로는 다른 구문으로 구성된 메서드의 코드 중복을 최소화할때 사용하는 패턴, 

다른 관점에서 보면 동일한 기능을 상위 클래스에서 정의하면서 확장/변화가 필요한 부분만 서브 클래스에서 구현할 수 있도록 함

(상위 클래스에서 템플릿을 구성하고 세세한 구현은 서브 클래스에서 구현함)

### 템플릿 메서드 패턴의 컬레보레이션
- AbstractClass : 템플릿 메서드를 정의하는 클래스, 하위 클래스에 공통 알고리즘을 정의하고 하위 클래스에서 구현될 기능을 primitive 메서드 또는 hook 메서드로 정의하는 클래스
- ConcreteClass : 물려받은 primitive 메서드 또는 hook 메서드를 구현하는 클래스, 상위 클래스에 구현된 템플릿 메서드의 일반적인 알고리즘에서 하위 클래스에 적합하게  primitive 메서드 또는 hook 메서드를 오버라이드 하는 클래스

# Chapter 12 팩토리 메서드 패턴
## 팩토리 메서드 패턴
=> 객체의 생성 코드를 별도의 클래스/메서드로 분리함으로써 객체 생성의 변화에 대비하는데 유용한 패턴

### 문제점
상황에 따라 적절한 객체를 생성하는 코드는 자주 중복될 수 있음 => 객체 생성 방식의 변화는 해당 되는 모든 코드 부분을 변경해야함

### 해결책
객체 생성 코드를 별도의 클래스/메서드로 분리해 이용한다면 이 클래스/메서드만 변경함으로써 객체 생성 방식의 변화에 효과적으로 대응

# Chapter 14 컴퍼지트 패턴
## 컴퍼지트 패턴
=> 부분-전체의 관계를 갖는 객체들을 정의할때 유용한 패턴

### 문제점
현재 Computer 클래스는 Body, Keyboard, Monitor 객체로 구성되어 있다. 만약 Computer 클래스의 부품으로 Speaker 클래스를 추가한다면? 또는 Mouse 클래스를 추가한다면?

=> 새로운 Speaker 클래스를 추가하게 되면 Computer 클래스에 새로 add 메서드와 getPrice, getPower 메서드를 수정해야 하기 때문에 OCP 에 위반하게 됨

### 해결책
구체적인 부품들을 일반화한 클래스를 정의하고 이를 Computer 클래스가 가리키게 함

### 컴퍼지트 컬레보레이션
- Component : 구체적인 부분, 즉 Leaf 클래스와 전체에 해당하는 Composite 클래스에 공통 인터페이스를 정의
- Leaf : 구체적인 부분 클래스로 Composite 객체의 부품으로 설정
- Composite : 전체 클래스로 복수 개의 Component 를 갖도록 정의, 복수 개의 Leaf, 심지어 복수 개의 Composite 객체를 부분으로 가질 수 있음.


