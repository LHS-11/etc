# Chapter 1 

객체지향 프로그래밍 => 문제와 관련된 다양항 객체들을 중점적으로 보고 각자 가진 데이터가 무엇이며 해당 데이터가 할 수 있는 것은 무엇이 있을까?</br></br>

객체가 내포한 데이터는 객체의 '**상태**', 객체에 행할 수 있는 행동은 '**동작**'</br></br>

절차나 메서드의 관점으로 생각</br></br>

Class => **템플릿** (객체가 갖고 있는 데이터 + 객체에 행할 수 있는 동작)
ex) 
사람이 클래스면 객체는 클래스의 인스턴스</br></br>

객체의 상태 = 필드 or 멤버 변수
객체에서 호출할 수 있는 동작 = 메서드</br></br>

보통 클래스는 대문자로 시작, 메소드나 필드는 소문자로 시작 (이후 Camel 표기법 사용)</br></br>

클래스 내부에 직접적으로 접근을 하면 안됨 => 캡슐화 파괴 ( so 필드 앞에 private를 붙여서 바로 접근을 못하게 함)</br></br>

캡슐화의 주요 기능
- 메서드를 통해 검증 가능 ( ex 속도에 음수 값이 못들어오게 막을 수 있음 )</br></br>

자바코드 -> 컴파일 -> 바이트 코드 생성 -> 자바 가상 머신(JVM) 실행</br></br>

캡슐화 => 특정 개체에 속하는 데이터를 숨겨 접근을 차단하고 연산만 허용</br></br>

추상화 => 캡슐화보다 더 포괄적인 개념 ( 모든 복잡한 내용을 숨기고 응용프로그램 인터페이스 유저는 복잡한 세부 내용을 전부 알 필요 X)</br>

생성자는 return 타입이 필요 없고 메서드 명칭이 클래스 이름과 같다!
=> 객체를 만들 때 해당 객체의 최초 상태를 설정 가능</br></br>

변수를 가지는 생성자를 생성시 디폴트 생성자도 만들어줘야 함 (만약 필요 하다면)</br></br>

디폴트 생성자에서 초기 상태 값을 주고 싶으면 this(speed) 이런식</br></br>

# Chapter 2
Integer => byte, short, int, long
size =>       1,     2,   4,    8
</br>
리터럴의 경우 뒤에 l 을 붙여여함
ex)
long size=10000000l;</br></br>

**작은 값을 큰 값에 담을 수는 있어도** (implicit 유형)

**큰 값을 작은 값에 담을 수는 없음** (만약 하고 싶으면 cast 함수를 통한 형변환 필요</br></br>

형변환 => cast 함수

ex) 
int size1;</br>
long size = 10000000l; </br>
int size1 = (int) size; -> 작은 값에 큰 값을 담기 때문에 casting (명시적 형변환이 필요)</br></br>

앞에 0을 붙이면 8진수 , 0x를 붙이면 16진수  

ex) 
int eight=010 => eight=8, int sixteen=0x8 => sixteen=16</br></br>


Floating Point (부동 소수점)
double, float</br></br>

float => 부동 소수 리터럴 (정수 뒤에 f를 붙여야함)

ex) 
float f= 34.5f</br></br>

부동 소수 데이터 유형은 정확하지 않음
=> 부동 소숫값이 표현되는 방식 때문에
해결책 : BigDecimal 사용</br></br>

BigDecimal 객체는 한 번 만든 이상 값을 변경할 수 없음 (**불변성**) => 새 변수만 생성해야함</br></br>

BigDecimal 객체를 계산할 때는 double x , string o

ex)
BigDecimal number = new BigDecimal("11.5")
int i=5;
number.add(new BigDecimal(i)) => 16.5</br></br>

&& 연산자와 & 연산자 차이
ex)
int i=10;
int j=15;
j>15 && i++>5 =>  && 수식 자체가 거짓이면 평가 자체를 하지 않음

=> i,j는 변하지 않음

j>15 & i++>5 => & 연산자 하나가 거짓임에도 다 실행

=> i=11,j=15</br></br>

# Chapter 3
switch 문에서는 long, double, float type X
=> char, int, byte, short, string, enum o</br></br>

참조타입 (클래스) -> 참조변수 (인스턴스, 객체)</br></br>

새로운 객체가 생성될 때마다 **Heap에 저장** (가장 기본적인 저장소)</br></br>

기본 변수들은 **Stack에 저장**</br></br>

**실제 객체 정보는 Heap에 저장 -> Stack에는 실제 객체가 저장된 메모리의 경로**</br></br>

String 클래스</br>
length()</br>
charAt()</br>
substring()</br>
indexOf() => 찾으려는 스트링의 첫 글자의 첫번째 인덱스를 출력</br>
lastIndexOf() => 찾으려는 스트링의 첫 글자의 마지막번째 인덱스를 출력</br>
contain() => 찾으려는 스트링이 있으면 true</br>
startsWith() => 찾으려는 스트링이 맨 앞에 있으면 true</br>
endsWith() => 찾으려는 스트링이 맨 뒤에 있으면 true</br>
empty()</br>
equals()</br>
equalsIgnoreCase() => 대소문자 관계없이</br>
concat() => 스트링을 다른 스트링에 연결</br>
trim() => 빈칸을 없애줌</br>
join() => 같은 스트링에서 값을 구분하고 싶을 때</br>
replace() => 특정 문자를 특정 문자로 대체</br>

String 클래스</br>
모든 스트링 리터럴은 클래스 인스턴스</br>

특정 클래스의 인스턴스가 되는 유일한 리터럴 타입</br>

스트링은 특별한 타입 => 생성자 없이도 새로운 인스턴스를 생성 가능 // 자바에서 자동으로 객체 생성</br>
ex) String s="awdsa";</br>

스트링은 값 변경 불가능 => 새로운 변수 생성해서 바꿔야함 **(불변성)**</br>
ex) String str="abc";</br>
    str="xyz"</br>
**의미 : 문자열 데이터는 Heap 영역 중에서 String constant pool 이라는 곳에서 메모리를 할당 받아 그 곳에 값을 저장하고</br>
Stack 에서 str 은 바로 그 주소값을 참조함 str="xyz" 으로 바꾸게 되면 Heap에서 "xyz"에 해당하는 새로 메모리를 할당하고</br>
Stack 에서 str 이 그 참조값으로 변경이 됨**</br></br>

스트링 + 정수 => 스트링</br>
ex) 1 + "123" -> "1123"</br></br>

----------------------------------------------------------------------------------------

StringBuffer 의 경우 불변성이 없다. (값을 변경 가능)</br>
=> 결합을 많이 수행해야 하는 경우 StringBuffer 사용 (메모리적으로 절약)</br>

StringBuilder => 동기화된 클래스, 멀티 스레딩이 가능한 클래스</br>

Wrapper Class => 추가적인 옵션을 다양하게 제공, 기본값에 객체를 제공</br>

래퍼 클래스는 스태틱 메서드(생성자), valueOf를 톨해 생성</br>

래퍼 클래스는 스트링 값을 넣을 수도 있음 but 불변성</br>

valueOf => 존재하는 객체 중 같은 값을 가지는게 있는지 확인하고 있으면 참조값을 가르킴 (재사용)</br>

Java5 에서는 Auto Boxing 을 통해 valueOf를 자동으로 실행</br>

SIZE (bit) , BYTES (byte)</br></br>

----------------------------------------------------------------------------------------

LocalDate, LocalDateTime, LocalTime class</br>

LocalDate - 날짜만 보여줌</br>
LocalDate today=LocalDate.now();</br>
- getYear()
- getDayOfWeek()
- getDayOfMonth()
- getDayOfYear()
- isLeapYear() => 윤년 확인 가능
- plusDays()
- of() => 특정 연, 월, 일 설정 가능
- WithYear (WithDayOfMonth, WithMonth, WithDayOfYear 등) 설정가능
- isBefore, isAfter => 날짜 비교 가능

LocalDateTime - 날짜와 시간을 모두 보여줌</br>
LocalTime - 시간만 보여줌</br></br>

# Chapter 4
**배열 선언**
ex)
int[] marks={1,2,3};
int[] marks=new int[3];

Arrays.toString(marks) => 배열의 콘텐츠 출력
Arrays.fill(marks,100) => 모두 100으로 채움
Arrays.equals(array1,array2) => 길이가 같고 각각의 요소가 같아야함
Arrays.sort => 정렬

Integer.MAX_VALUE
Integer.MIN_VALUE

BigDecimal 불변성

**가변 인수** => 인수에 갯수 제한없이 여러개를 받을 수 있음, 무조건 마지막 인수여야함!
ex) void print(**int... values**){
    System.out.println(Arrays.toString(values));
}

배열 만드는 방법
ex)
Student[] student=new Student[5];
student[1]=new Student();
Student[] student2={new Student(),new Student()};
String[] string={"apple","banana","kiwi"}

Array(배열) 를 한번 만들면 크기 수정 안됨 
=> 새로운 Array 만들어서 거기다 추가하거나 삭제 해야함 
-> **ArrayList**를 사용하면 해결 가능

ArrayList
String 타입의 ArrayList 를 생성시
=>** ArrayList<String> items=new ArrayList<String>()**;

ArrayList 는 Collection 의 일부이기 때문에 Collection 메소드 사용 가능
Collections.max(marks)

toString() => 객체명 출력시 해시 값이 나오는데, toString 메서드가 있다면 그 객체의 값(정보)가 나옴
public String toString(){
    return
}
