함수형 프로그래밍

stream().forEach(action) => 흐름의 각 요소마다 함수를 보냄

각 요소가 흐름되고 각 요소들에 대해 코드가 실행

filter(logic) => if문

reduce(초기값, (함수 정의))
ex) List<Integer> list = List.of(1, 2, 3, 4, 5);
list.steam().reduce(0,(num1,num2) -> num1+num2);
num1=0, num2=1
-> num1=1, num2=2
-> num1=3, num2=3
-> num1=6, num2=4
-> num1=10, num2=5
-> num1=15

함수형 프로그래밍과 일반 절차적 프로그래밍의 차이점
=> 변수 변이를 피함

element -> element %2==0 => 여기서 -> 람다 표현식

- 중간 연산 : 또 다른 스트림
ex) filter, sorted, distinct, map
- 종단 연산 : 요소를 처리하고 소모 ( 스트림을 입력값으로 받아 하나의 결과로 줄이는 것)
무조건 하나 => 스트림이 모두 소모돼 하나의 결과로 줄여주기 때문에 하나일 수 밖에 없다
ex) forEach, reduce, max((num1,num2) -> Integer.compare(num1,num2))

IntStream=> Stream 이 아님 (IntPipeline)
(So, boxed()를 통해서 스트림의 정수형 배열로 변환)

Optional => isPresent(), orElse()

자바 컴파일러가 함수형 인터페이스 실행
( filter -> predicate (test 메서드) , forEach -> Consumer (accept 메서드) , map -> Function (apply 메서드 ))

메서드 참조 => 축약 가능 ( 코드의 가독성을 높이기 위함 )
클래스 이름 :: 메서드 이름
ex) filter(n -> n%2==0) => filter(클래스 이름::isEven)
public static boolean isEven(Integer number){
    return number%2==0;
}

