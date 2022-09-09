# Chapter1
객체지향 프로그래밍 => 문제와 관련된 다양항 객체들을 중점적으로 보고 각자 가진 데이터가 무엇이며 해당 데이터가 할 수 있는 것은 무엇이 있을까?

객체가 내포한 데이터는 객체의 '상태', 객체에 행할 수 있는 행동은 '동작'

절차나 메서드의 관점으로 생각

Class => 템플릿 (객체가 갖고 있는 데이터 + 객체에 행할 수 있는 동작)
ex) 사람이 클래스면 객체는 클래스의 인스턴스

객체의 상태 = 필드 or 멤버 변수
객체에서 호출할 수 있는 동작 = 메서드

보통 클래스는 대문자로 시작, 메소드나 필드는 소문자로 시작 (이후 Camel 표기법 사용)

클래스 내부에 직접적으로 접근을 하면 안됨 => 캡슐화 파괴 ( so 필드 앞에 private를 붙여서 바로 접근을 못하게 함)

캡슐화의 주요 기능
1) 메서드를 통해 검증 가능 ( ex 속도에 음수 값이 못들어오게 막을 수 있음 )

자바코드 -> 컴파일 -> 바이트 코드 생성 -> 자바 가상 머신(JVM) 실행

캡슐화 => 특정 개체에 속하는 데이터를 숨겨 접근을 차단하고 연산만 허용

추상화 => 캡슐화보다 더 포괄적인 개념 ( 모든 복잡한 내용을 숨기고 응용프로그램 인터페이스 유저는 복잡한 세부 내용을 전부 알 필요 X)

생성자는 return 타입이 필요 없고 메서드 명칭이 클래스 이름과 같다!
=> 객체를 만들 때 해당 객체의 최초 상태를 설정 가능

변수를 가지는 생성자를 생성시 디폴트 생성자도 만들어줘야 함 (만약 필요 하다면)

디폴트 생성자에서 초기 상태 값을 주고 싶으면 this(speed) 이런식
