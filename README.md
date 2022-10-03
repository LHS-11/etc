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

----------------------------------------------------------------------------------------
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

=> i=11,j=15</br>

----------------------------------------------------------------------------------------
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
LocalTime - 시간만 보여줌</br>

----------------------------------------------------------------------------------------
# Chapter 4
**배열 선언**    
ex)</br>
int[] marks={1,2,3};</br>
int[] marks=new int[3];</br></br>

Arrays.toString(marks) => 배열의 콘텐츠 출력</br>
Arrays.fill(marks,100) => 모두 100으로 채움</br>
Arrays.equals(array1,array2) => 길이가 같고 각각의 요소가 같아야함</br>
Arrays.sort => 정렬</br></br>

Integer.MAX_VALUE</br>
Integer.MIN_VALUE</br></br>

BigDecimal 불변성</br></br>

**가변 인수** => 인수에 갯수 제한없이 여러개를 받을 수 있음, 무조건 마지막 인수여야함!</br>
ex) void print(**int... values**){</br>
    System.out.println(Arrays.toString(values));</br>
}</br></br>

배열 만드는 방법</br>
ex)</br>
Student[] student=new Student[5];</br>
student[1]=new Student();</br>
Student[] student2={new Student(),new Student()};</br>
String[] string={"apple","banana","kiwi"}</br></br>

Array(배열) 를 한번 만들면 크기 수정 안됨 </br>
=> 새로운 Array 만들어서 거기다 추가하거나 삭제 해야함 </br>
-> **ArrayList** 를 사용하면 해결 가능</br></br>

ArrayList</br>
String 타입의 ArrayList 를 생성시</br>
=> **ArrayList<String> items=new ArrayList<String>();** </br></br>

ArrayList 는 Collection 의 일부이기 때문에 Collection 메소드 사용 가능</br>
ex) Collections.max(marks)</br></br>

toString() => 객체명 출력시 해시 값이 나오는데, toString 메서드가 있다면 그 객체의 값(정보)가 나옴</br>
```
public String toString(){

    return
    
}
```
----------------------------------------------------------------------------------------
# Chapter 5
class => 단순한 템플릿</br>
템플릿을 바탕으로 객체(인스턴스) 생성</br></br>

객체 => 상태(변수) + 행동(메서드)</br></br>

class 를 만들 때 고려해야 하는 것</br>
1. 상태</br>
2. 생성자</br>
3. 행동</br>
=> **사용자의 입장**에서 생각</br></br>

객체 구성 관계</br>

**상속** (IS A 관계)=> 다른 클래스에서 이미 사용 중인 코드를 재사용할 때 유용함</br>
ex) Person (수퍼 클래스) - Student (서브 클래스) => Student IS A Person</br>
서브 클래스가 슈퍼 클래스를 확장하며 서브 클래스는 슈퍼 클래스의 모든 기능을 가지게 됨</br></br>

기본적으로 클래스가 다른 클래스에서 아무것도 상속 받지 않는다면 **Object 클래스(디폴트 값)** 를 상속받음</br></br>

하위클래스에서 상위클래스에 있는 메서드를 **오버라이딩**을 통해 **재정의 가능**하다.</br></br>

**하위클래스에서 생성자를 생성시 자동으로 상위클래스 생성자 호출**</br></br>

java 에서는 **다중 상속이 되지 않음** (C++에선 가능) but 상속 계층은 가능</br></br>

하위 클래스 변수를 담을 수 있는 상위 클래스 참조 변수를 생성 가능</br>
ex) Pet pet = new Dog(); ( public class Dog extends Pet )</br></br>

상위 클래스 변수는 하위 클래스 변수를 담을 수 있다.</br>
=> 상위 클래스에서 하위 클래스 변수를 참조 가능</br></br>


**instanceof** => 현재 객체가 **특정 클래스의 인스턴스인지** 알 수 있게 해줌</br>
ex) Animal - Pet - Dog</br>
(하위클래스의 객체) instanceof (상위클래스 or 해당 type) => true -> 현재 객체가 상위 클래스의 인스턴스인지 확인 가능</br>
pet instanceof Animal => true</br>
dog instanceof Pet => true</br>
pet instanceof Dog => false</br>
but</br>
Pet pet=new Dog(); // 만약 pet이 Dog 인스턴스로 생성했다면</br>
pet instanceof Dog => true 가 될 수 있음!!</br></br>

**추상 클래스 => abstract class Animal(){}**</br></br>

**추상 메서드는 추상 클래스에서만 생성 가능**, 비추상적 메서드는 추상 클래스에서 생성 가능</br></br>

**모든 추상 클래스들은 높은 단계의 알고리즘을 적용하고 자세한 세부정보들은 적용 클래스들에게 맡김**</br>
ex)
```
public abstract class AbstractRecipe {

    public void execute(){
        getReady();
        doTheDish();
        cleanup();
    }

    abstract void getReady();

    abstract void doTheDish();

    abstract void cleanup();

}
```
</br></br>

인터페이스와 추상 클래스의 차이 **(활용도는 같을 수 있지만 사고 방식 면에서 완전히 다름)**</br></br>
**인터페이스**</br>
=> **두 시스템 사이에 소통하길 원할 때, 두 클래스 아니면 두 부속이 서로 소통하길 원할 때** (Dummy 알고리즘으로 대체해서 사용하다가 real 알고리즘으로 변경하면 됨) </br>
-> 프로젝트는 계속 진행 가능</br></br>
**추상클래스**</br>
=> 높은 단계의 구조를 제공하고 싶어할 때, **구현의 세세한 부분들을 하위 클래스에 맡기고 싶을 때**</br></br>

**다형성 => 같은 것에 여러가지 구현을 부여**</br></br>

인터페이스가 공통 행동을 클래스에게 제공</br></br>

**인터페이스는 외부 인터페이스가 실제로 사용 가능하지 않아도 작업을 계속할 수 있게 해줌 (교체 하면 그만!!) => 통신 계약**</br></br>

인터페이스는 또 다른 인터페이스를 연장 가능</br></br>

인터페이스 안의 메서드들은 **무조건 개방형** (private 사용 X)</br></br>

자신이 연장하는 인터페이스에 대한 구현이 없는 그저 인터페이스만 구현하는 추상 클래스를 생성 가능</br>
=> 인터페이스에 있는 메서드를 다 구현하고 싶지 않다면 추상 클래스를 통해 implements 해줘야 함</br></br>

인터페이스 안에서 변수가 아닌 상수를 만들 수 있음 </br>
(자동으로 public static final 이 붙음)</br>
ex)</br>
```
interface Runnable{
    int i=10;
}
class Student {
    public void print(){
        System.out.println(Runnable.i);
    }
}
```

return 값 앞에 default 키워드를 붙이면 구현 가능 => adapter 패턴의 단점을 보완해줌 (이미 상속 중일 땐 adpater 패턴 적용 못하는 단점) </br>
adapter 패턴 => 인터페이스의 강제성을 덜어줌 (필터링) </br>
ex)
```
interface Runnable{
	default void run(){
    	System.out.println("run");
    }
}
```
</br></br>
인터페이스는 시행될 수 있는 공통된 행동들을 대표함</br></br>

인터페이스 종류의 참조 변수는 인터페이스 구현을 가질 수 있음</br>

----------------------------------------------------------------------------------------
# Chapter 6
Collections</br>

List<String> words = List.of("Apple","Bat","Banana"); => 한번에 리스트 구성 (하나씩 add 할 필요없이)</br></br>

words.get(0) => "Apple"</br>

words.contain("Bat") => true</br>

words.indexOf("Banana") => 2</br>
words.indexOf("A") => -1</br></br>

불변성 => 특정 클래스의 인스턴스를 만든 순간부터 이 값을 변경 X</br>
ex) String , BigDecimal, Wrapper, List</br></br>

**List (불변성) <-> ArrayList, LinkedList, Vector (가변성)**</br>
ex)
```
List<String> words = List.of("Apple","Bat","Banana") => 불변성 (List.of로 구성)
List<String> words=new ArrayList<String>() => 가변성
List<String> words=new LinkedList<String>()
List<String> words=new Vector<String>()
```

배열의 경우 삽입과 삭제에 비효율 but **접근성은 좋음**</br>
LinkedList 의 경우 **삽입과 삭제에 효과적** but 접근성은 비효율</br></br>

Vector 는 **Thread Safe (Synchronized Methods)** => 성능 구림</br>
**안전이 필요하지 않으면 ArrayList 쓰자**</br></br>

ArrayList.add(index, n) => index 에 n 삽입</br>
ArrayList.addAll()</br>
ArrayList.set(index, n) => index 의 값을 n으로 변경</br>
ArrayList.remove(index) => index 의 값을 제거</br>

리스트 iterator 이용해서 출력
ex)
```
Iterator wordsIterator=words.iterator();
while(wordsIterator.hasNext()){
    System.out.println(wordsIterator.next());
}
```

특정 원소를 제거시
ex) 
  ```
List<String> words=List.of("Apple","Cat","Bat");
List<String> wordAl=new ArrayList<>(words);

Iterator<String> iterator=wordsAl.iterator();
while(iterator.hasNext()){
    if(iterator.next().endsWith("at")){
        iterator.remove();
    }
}
wordAl=> [Apple]
```

List value=List.of("A",'A',1,1.0)</br>
=> List 에서 type 에 상관없이 담을 수 있음 -> 특정한 type 만 담고 싶다면 Generation (일반화)</br></br>

Collections.sort(객체 이름) => 정렬</br></br>

ArrayList.sort()</br>

--------------------------------------------------------------------
Set 인터페이스 => 중복 X</br></br>

**Set, HashSet** 은 요소의 친구 상관 안함 **(순서대로 저장 X, 정렬 X)**</br>
<-> **LinkedHashSet 은 순서대로 저장**</br>
<-> **TreeSet 은 정렬됨**</br></br>

Set 특정 위치에 요소를 추가하거나 제거 X</br></br>

Hashing 함수의 경우 13을 나눈 나머지 값을 index 로 가짐</br>
=> 해시코드라는 것을 이용해 구현</br></br>

Tree(red-black tree) => 검색, 제거, 삽입의 소모성을 줄여주는데 효과적</br>

TreeSet.floor(n) => n보다 작거나 같은 것</br>
TreeSet.lower(n) => n보다 작은 것</br>
TreeSet.ceiling(n) => n보다 크거나 같은 것</br>
TreeSet.subSet(a,b) => a보다 크거나 같고 b보단 작다</br>
TreeSet.subSet(a,True,b,True) => a보다 크거나 같고 b보단 작거나 같다</br>
TreeSet.headSet(n) => n 이전의 모든 숫자 출력</br>
TreeSet.tailSet(n) => n 부터 모든 숫자 출력</br></br>

queue</br>
Queue.poll() => 맨 앞에 요소를 꺼내고 출력</br>
Queue.offer() => 요소 추가</br>
Queue.addAll(List.of()) => 여러 요소 추가</br></br>

**Comparator 를 이용해서 커스텀 정렬 가능**</br>
ex)
```
class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
    }
}
```
----------------------------------------------------------------------

HashMap => key 값을 null 값과 저장 가능</br></br>

**HashTable => 해싱함수 사용, 동기화 (스레드 안전 => 스레드가 작업을 하고 있으면 그 작업이 끝날 때까지 기다림 so 성능은 안좋음)**</br></br>

HashMap, HashTable <-> LinkedHashMap <-> TreeMap</br></br>

.of() => 이용해서 만들면 불변성을 지님 (추가 안됨)</br></br>

Map.containsKey()</br>
Map.containsValue()</br>
Map.keySet()</br>
Map.values()</br>

TreeMap - NavigableMap</br>
TreeMap.higherKey(n) => n보다 큰 key 값</br>
TreeMap.lowerKey(n) => n보다 작은 key 값</br>

TreeMap.ceilingKey(n) => n보다 같거나 큰 key 값</br>
TreeMap.floorKey(n) => n보다 같거나 작은 key 값</br>

TreeMap.firstEntry() => 처음 값</br>
TreeMap.lastEntry() => 마지막 값</br>

TreeMap.subMap(a,b) => a보다 같거나 크고, b보다 작은 key,value 값</br>

----------------------------------------------------------------------------------------
# Chapter 7
특정 타입이 아닌 여러 타입을 받고 싶을때 Generics 이용</br></br>
클래스에 제네릭 생성</br>
ex) 
```
public class MyCustomList<T>{
    ArrayList<T> list=new ArrayList<>();

}
```

메서드에 제네릭 생성</br>
ex)
```
static <X> X doubleValue(X value){ // 어떤 값도 출력 가능
        return value;
}
static <X extends List> void duplicate(X list){ // List 계열만 ArrayList, Vector, LinkedList
        list.addAll(list);
}
```

Number -> Integer, Double, Float, Byte, Int, Long, Short</br></br>

**상한 경계 와일드 카드** => Number 클래스를 연장하는 **Number 클래스의 하위 클래스인 모든 리스트들에 대해 공통된 논리를 구현하는데 도움**</br>
ex)
```
static Double sumOfNumberList(List<? extends Number> list){  => ? : 와일드 카드
        double sum=0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
}
```

**하한 경계 와일드 카드** => 숫자의 하위 타입들의 **여러 다른 값들을 많이 추가 가능하게 해줌**</br>
ex)
```
static void addCoupleOfValues(List<? super Number> list){
        // 숫자 클래스의 하위 클래스인 이상 아무 종류나 list 에 추가 가능
        list.add(1);
        list.add(1.0);
        list.add(2L);

}
```

----------------------------------------------------------------------------------------
# Chapter 8 - 함수형 프로그래밍
**함수형 프로그래밍**</br></br>

stream().forEach(action) => 흐름의 각 요소마다 함수를 보냄</br>

각 요소가 흐름되고 각 요소들에 대해 코드가 실행</br></br>

filter(logic) => if문</br></br>

reduce(초기값, (함수 정의))</br>
ex)
```
 List<Integer> list = List.of(1, 2, 3, 4, 5);
list.steam().reduce(0,(num1,num2) -> num1+num2);
num1=0, num2=1
-> num1=1, num2=2
-> num1=3, num2=3
-> num1=6, num2=4
-> num1=10, num2=5
-> num1=15

```
함수형 프로그래밍과 일반 절차적 프로그래밍의 차이점</br>
=> 변수 변이를 피함</br></br>

**element -> element %2==0** => 여기서 -> **람다 표현식**</br></br>

- 중간 연산 : 또 다른 스트림</br>
ex) filter, sorted, distinct, map</br></br>
- 종단 연산 : 요소를 처리하고 소모 ( 스트림을 입력값으로 받아 하나의 결과로 줄이는 것)</br>
무조건 하나 => 스트림이 모두 소모돼 하나의 결과로 줄여주기 때문에 하나일 수 밖에 없다</br>
ex) 
```
forEach, reduce, max((num1,num2) -> Integer.compare(num1,num2))
```

IntStream=> Stream 이 아님 (IntPipeline)</br>
(So, boxed()를 통해서 스트림의 정수형 배열로 변환)</br></br>

Optional => isPresent(), orElse()</br></br>

자바 컴파일러가 함수형 인터페이스 실행</br>
- filter -> Predicate (test 메서드)  </br>
- forEach -> Consumer (accept 메서드)  </br>
- map -> Function (apply 메서드 )</br></br>

메서드 참조 => 축약 가능 ( 코드의 가독성을 높이기 위함 )</br>
클래스 이름 :: 메서드 이름</br>
ex) 
```
filter(n -> n%2==0) => filter(클래스 이름::isEven)
public static boolean isEven(Integer number){
    return number%2==0;
}
```

----------------------------------------------------------------------------------------
# Chapter 9
**Thread 는 유사성을 가진 모든 수행문을 동시에 실행하게 해줌</br>
=> 자원 낭비를 줄여줌 (CPU 효율성 향상)</br>
=> 병렬적으로 함께 실행 가능**</br></br>

1. **Thread 확장 (Thread 상속)**</br>
ex) 
```
class Task1 extends Thread{
    public void run(){

    }
}
=> Task1 task1=new Task1();
task1.start();
```


2. **Runnable 인터페이스 실행**</br>
ex) 
```
class Task1 implements Runnable{
        public void run(){

        }
}
=> Task2 task2=new Task2();
Thread task2Thread= new Thread(task2);
```

**Thread 상태**</br>
- NEW : Thread 가 처음 생성될 때의 상태</br>
- RUNNABLE : 일 혹은 작업을 처리하고 싶기는 하지만, 다른 Thread 가 우선적으로 실행되고 있는 상태</br>
- RUNNING : Thread 가 실행 중인 상태</br>
- BLOCKED/WAITING :</br>
외부 인터페이스나 데이터베이스 등으로부터 어떤 입력을 위해 대기하고 있거나, 실행이 완료되지 않은 다른 Thread 로부터 데이터를 입력받아야 하는 상황</br>
- TERMINATED/DEAD : 실행이 완료되었을 경우 의미</br></br>

**Thread 우선순위**</br>
setPriority (1~10)</br>
=> 추천일 뿐 강제가 아님</br></br>

**Threads 사이의 소통**</br>
join 메서드 => 특정 Thread 의 실행이 끝날 때까지 대기한다는 의미 ( task 가 완료된 후에나 다음 줄의 코드 실행 )</br></br>

Thread.sleep(1000) => 1초 동안 대기</br></br>

Thread.yield() => CPU 를 포기하도록 요청</br></br>

synchronized ( 동기화 ) => 하나의 쓰레드에 동기화된 코드의 작업 가능 so 오버헤드</br></br>

Executor Service ( 실행기 ) => 다수의 쓰레드를 한 번에 실행할 수 있도록 도와줌, 쓰레드의 상태를 알게 해줌</br></br>

**newSingleThreadExecutor** (한 개의 쓰레드) <-> **newFixedThreadPool** (여러 개의 쓰레드)</br></br>

Thread 에서 결과를 얻는 지점 또한 설정 가능</br></br>

Callable => Callable 인터페이스를 이용해서 후처리 스레드로 돌아오기</br></br>

Future (결과가 나올 것이라고 예측)</br>
ex) 
```
Future<String> welcomeFuture
                   = executorService.submit(new CallableTask("Paul"));
                   submit() 메서드를 통해 callable 실행 가능
    String welcomeMessage = welcomeFuture.get(); => task 가 실행될 때까지 기다림, task 가 실행을 끝낸 뒤에나 이 다음 코드 실행
    get() 메서드를 쓰는 시점 이후부터 후처리
```

**invokeAll** : 모든 작업이 완료된 후에 한번에 다 출력 (모든 task 의 처리가 끝날 때까지 기다림)</br>
**invokeAny** : 하나의 작업이 먼저 끝나면 먼저 결과를 출력 (한개의 task 가 실행이 완료되는 것을 기다린 후, 결과를 얻음)</br>

----------------------------------------------------------------------------------------
# Chapter 10 - Exception
**Exception Handling** ( 예외 처리 ) 2 가지 키</br>

1. 제가 이용하려는 시스템의 최종 사용자에게 친절하게 메시지를 남기는 것 (어떤 작업 또는 단계를 거쳐야 하는지 알림)</br>
2. 오류를 제거하기 위한 충분한 정보를 제공</br></br>

call chain</br></br>

try ~catch, throws</br></br>

**예외에서 서열 존재**</br>
Exception > RuntimeException > NullPointException</br></br>

finally</br>
=> 예외가 생기든 안생기든 **finally 블럭 코드 실행** (무조건 절대적 return 값이 try 문에 있어도 실행됨)</br>
but System.exit 의 경우에는 실행 X</br></br>

**try 는 단독으로 쓰일 수 없다. (무조건 catch 나 finally 와 같이 쓰여야함)**</br></br>

**점검 예외 처리 vs 비점검 예외 처리**</br>

class Error extends Throwable => **Error 는 프로그래머가 처리할 수 없는 오류** (메모리를 모두 사용한 경우, JVM 메모리, stack overflow 에러등)</br>
class Exception extends Throwable => **Exception 는 프로그래머가 처리 할 수 있는 오류**</br></br>

Exception 항목 아래 **RuntimeException 이 아닌 것들이 checked exceptions** ( 처리하기 까다로운 것들)</br>
=> calling 메서드가 이를 처리하거나 또 다시 떠넘기는 방법 사용</br>
=> 예외를 처리해줘야함</br>
=> throws 를 앞에 붙여줘야함</br></br>

**RuntimeException => unchecked exception** ( calling 메서드가 아무 처리 안해도 됨 => 예외를 밖으로 던지는 것을 걱정할 필요 없다)</br></br>

if) 소비자가 예외를 처리할 수 있다면 (예외가 생겼다는 것을 알리길 바란다면) **checked exception** => 사용자에게 압박을 줌</br>
소비자가 대응할 수 없는 일이라면 **RuntimeException 을 사용**</br>

try-with-resources => try( ) 기능을 자료들에 사용 (구체적인 상황이라서 catch 나 finally 불필요 )</br>
ex)
```
 public class TryWithResourcesRunner {
        public static void main(String[] args) {

            try(Scanner scanner = new Scanner(System.in)) { // 오류가 생기면 알아서 close 해줌
                int[] arr = {12, 3, 4, 5};
                int a = arr[3];

            }
        }
    }

```
두개 이상의 예외를 한번에 다룰 수도 있음</br>
```
catch ( IOException | SQLException ex) {
 ex.printStackTrace();
}
```

예외를 다루는데 있어서 최고의 방법들</br>
1. 예외를 숨기지 말자 => stack trace 의 전부를 log 에 넣음</br>
2. flow control 사용 X => if-else 사용 X</br>
3. 사용자를 생각하라 => 최종 사용자에게 어떻게 설명 할지를 생각하라</br>
4. calling 메서드에 대해 생각하라 => RuntimeException 으로 만들 필요가 없는지 생각</br>
5. global exception handling => 모든 것을 관장하는 무언가를 설정 (사용자에게 예외가 직접 전달되는 일이 없도록) -> 예외에 대한 올바른 메시지가 출력되어야 함</br>

# Chapter 11 - File
**자바의 파일과 디렉토리**</br></br>

**파일들을 목록으로 정리하는 메서드**</br>
=> Files.list(경로)</br>
ex)
```
public class DirectoryScanRunner {
       public static void main(String[] args) throws IOException {
           Files.list(Paths.get(".")).forEach(System.out::println);
       }
   }
```

**전체 디렉토리를 가져오고 싶을 때 (재귀적인 방법)**</br>
=> Files.walk(경로)</br></br>

**원하는 파일을 찾는 메서드**</br>
=> Files.find(경로,깊이,람다식)</br>
파일의 attributes 들을 기준으로 필터링하여 디렉토리가 맞는지, 크기가 얼마만한지등 여러가지 알 수 있음</br>
파일의 이름이나 path, 파일의 특성에 따라 필터링 하는 것이 가능</br></br>

**파일에서 내용 불러오는 메서드**</br>
=> Files.readAllLines(경로)</br>
모든 줄의 내용을 리스트 형식으로 한번에 출력 but 큰 용량의 파일을 다룰 땐 좋은 방법이 아님</br>
So Files.lines(경로) => Stream 이용 (filter, map 같은 다양한 연산 사용 가능)</br></br>

**파일에 내용 담기**</br>
=> Files.write(경로,담을 내용)</br></br>

# Chapter 12 - 원자성
**동시 컬렉션의 동시성과 활용한 원자 연산**</br></br>

concurrency</br></br>

counter</br></br>

automic operation</br></br>

**thread-safety => 임의의 메소드가 다양한 thread 에 의해 한 번에 안전하게 실행되는 것**</br></br>

**not thread-safe -> synchronized 를 붙이면 됨**</br>
-> 문제점 : 적은 병행성을 가짐 ( 동기화(synchronized)된 메서드들이 여러개일 경우 각 메서드가 독립성을 가져도 여러 thread 들이 대기하는 상황이 생길 수 있음)</br>
해결책 : **Lock** 를 사용시 코드를 synchronized 없이도 동기화해주거나 thread-safe 하게 해줌</br>
( locks => 동기화된 코드를 여러 조각의 코드로 쪼갤 수 있게 해줌 )</br></br>

**atomic class**</br>
=> AtomicInteger</br>
AtomicInteger 에 의존하여 thread-safe 한지를 확인하게 됨 ( locks 에 의무를 가져와서 AtomicInteger 에 부여)</br>
아무곳이나 사용 X => 다양한 연산의 과정들이 필요할 경우 AtomicInteger 보단 lock 사용</br></br>

**ConcurrentHashMap** => 해당 인터페이스에 computeIfAbsent() 메서드가 있는데 이 메서드가 atomic 연산을 보장해줌</br>
so ConcurrentHashMap 을 불러내는 순간 thread-safe 에 해당</br>
ConcurrentHashMap 은 지역을 나눠서 각 지역마다 다른 lock 를 사용해서 자원을 조금 더 효율적으로 사용 가능하게 함</br</br>></br>

**CopyOnWrite**</br>
=> write 가 매우 적고, read 가 매우 많은 경우에 효율적</br>
=> 수정시 array 전체를 복사 (복사하는 동안 그 전의 array 를 이용함)</br>
=> 동시성 (Concurrency) 확보</br></br>

# Chapter 13 - java tip
#### static imports
ex)
import static java.lang.System.out;
=> System.out.println() -> out.println() 가능
import static java.util.Collections.*;
=> Collections.sort() -> sort() 가능

#### block
=> if 문에서만 사용되는 것이 아님, block 을 지정하고 그 안에 변수를 선언하면 그 block 안에서만 유효
ex) {
 int i;
}

#### equals
=> 객체가 같을 때만 true, 안에 정보가 같다고 같은게 아님 (서로 다른 메모리에 위치)</br></br>

#### hashcode
=> hashcode 를 기준으로 bucket 에 배정</br>
=> equals() 메서드를 실행할 때 hashCode() 메서드도 실행해야함</br></br>

#### 클래스 접근 제어자
public - 클래스가 public 에 해당한다면 다른 패키지의 클래스에서도 사용 가능</br>
default - 클래스가 (default) 의 경우 해당 패키지 안에서만 사용 가능</br>
protected, private 은 클래스에 사용 불가능</br></br>

#### 메소드 접근 제어자
public - 오로지 public 만 다른 패키지에서도 접근 가능</br>
default - 같은 패키지이거나 자식 클래스(상속)에서 접근 가능</br>
private - 같은 패키지 안에서 접근 불가능 (오로지 같은 클래스 안에서만 접근 가능)</br>
protected - 같은 패키지이거나 해당 클래스에서만 접근 가능</br></br>

#### final 클래스, final 메서드
final 클래스 - 상속 불가능 (extends X), 특정 클래스에 대한 확장을 허용하고 싶지 않을 때 사용</br>
final 메서드 - 코드 오버라이딩 불가능</br></br>

#### final 변수, final 전달인자
final 변수 - 불변성을 가짐 (값이 고정되길 원할 때), 단 한번만 값 부여 가능 (but, 생성자를 통해 인스턴스 마다 값을 달리 할 수 있다.)</br>
final 전달인자 - final 을 이용해서 값을 받을 때 전달인자 수정 불가능</br></br>

#### static 변수
static 변수 - 다수의 인스턴스 사이에서 공유 가능 (각 인스턴스에 대해 별도의 인스턴스를 갖는 상황이 아닌 하나의 인스턴스만 갖길 원할 때)</br>
ex) Player 클래스에서 인원수를 카운팅 할 때 static 이용하면 인스턴스를 생성할 때마다 카운팅이 됨</br></br>

#### static 메서드
=> 인스턴스 없이 클래스 이름에서 static 메서드 바로 사용 가능</br>

static 메서드 안에서는 인스턴스 데이터에 접근 불가능 (static 인 데이터만 접근 가능)</br>
<-> 반대는 가능</br></br>

**public static final 변수 - 상수 (정의)**</br>
=> 작업을 좀 더 분명하고 쉽게 전달</br>
**public final 변수와 차이점 : 그저 final 만 선언한 변수의 경우 생성자를 통해서 인스턴스마다 값을 변경할 수 있다.</br>
but public static final 은 가능하지 않다.**</br>

#### 중첩 클래스 - 내부 클래스 vs 정적 중첩 클래스
내부 클래스들(nested classes) 은 다른 클래스 안에 들어가 있는 class 를 말함</br>
전체 클래스의 선언이 다른 클래스 안에서 이루어짐</br>
내부 클래스는 외부 클래스의 인스턴스가 필요 하지만 정적 중첩 클래스는 외부 클래스의 인스턴스가 필요 없다</br>
but 내부 클래스는 외부 클래스의 멤버 변수에 접근 할 수 있지만, 정적 중첩 클래스는 불가능

ex)
```
public class NestedClassRunner {

    class InnerClass{

    }

    static class StaticNestedClass{

    }

    public static void main(String[] args) {

        StaticNestedClass staticNestedClass = new StaticNestedClass();

        NestedClassRunner nestedClassRunner = new NestedClassRunner();

        InnerClass innerClass = nestedClassRunner.new InnerClass();

    }
}
```

#### 익명 클래스 => 다른 곳에서 사용되면 안됨. ( 이 논리가 여기에만 쓰인다는 것을 확신할 때 사용)
ex)
```
 Collections.sort(animals,
                new Comparator<String>() { // 익명 클래스
                    @Override
                    public int compare(String o1, String o2) {
                        return Integer.compare(o1.length(), o2.length());
                    }
                });
```

#### Enum (열거형) => 특정 값에 제한을 두기 위해서 사용
열거형 , 인스턴스 변수에 저장 가능</br>
ex)
```
public enum Season{
    WINTER(4), SPRING(1),SUMMER(2), FALL(3);

    private int value;
    private Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
```

