참조타입 (클래스) -> 참조변수 (인스턴스, 객체)

새로운 객체가 생성될 때마다 Heap에 저장 (가장 기본적인 저장소)

기본 변수들은 Stack에 저장

실제 객체 정보는 Heap에 저장 -> Stack에는 실제 객체가 저장된 메모리의 경로

String 클래스
length()
charAt()
substring()
indexOf() => 찾으려는 스트링의 첫 글자의 첫번째 인덱스를 출력
lastIndexOf() => 찾으려는 스트링의 첫 글자의 마지막번째 인덱스를 출력
contain() => 찾으려는 스트링이 있으면 true
startsWith() => 찾으려는 스트링이 맨 앞에 있으면 true
endsWith() => 찾으려는 스트링이 맨 뒤에 있으면 true
empty()
equals()
equalsIgnoreCase() => 대소문자 관계없이
concat() => 스트링을 다른 스트링에 연결
trim() => 빈칸을 없애줌
join() => 같은 스트링에서 값을 구분하고 싶을 때
replace() => 특정 문자를 특정 문자로 대체

String 클래스
모든 스트링 리터럴은 클래스 인스턴스

특정 클래스의 인스턴스가 되는 유일한 리터럴 타입

스트링은 특별한 타입 => 생성자 없이도 새로운 인스턴스를 생성 가능 // 자바에서 자동으로 객체 생성

스트링은 값 변경 불가능 => 새로운 변수 생성해서 바꿔야함 (불변성)

스트링 + 정수 => 스트링

----------------------------------------------------------------------------------------

StringBuffer 의 경우 불변성이 없다. (값을 변경 가능)
=> 결합을 많이 수행해야 하는 경우 StringBuffer 사용 (메모리적으로 절약)

StringBuilder => 동기화된 클래스, 멀티 스레딩이 가능한 클래스

Wrapper Class => 추가적인 옵션을 다양하게 제공, 기본값에 객체를 제공

래퍼 클래스는 스태틱 메서드(생성자), valueOf를 톨해 생성

래퍼 클래스는 스트링 값을 넣을 수도 있음 but 불변성

valueOf => 존재하는 객체 중 같은 값을 가지는게 있는지 확인하고 있으면 참조값을 가르킴 (재사용)

Java5 에서는 Auto Boxing 을 통해 valueOf를 자동으로 실행

SIZE (bit) , BYTES (byte)

----------------------------------------------------------------------------------------

LocalDate, LocalDateTime, LocalTime

LocalDate - 날짜만 보여줌
LocalDate today=LocalDate.now();
- getYear()
- getDayOfWeek()
- getDayOfMonth()
- getDayOfYear()
- isLeapYear() => 윤년 확인 가능
- plusDays()
- of() => 특정 연, 월, 일 설정 가능
- WithYear (WithDayOfMonth, WithMonth, WithDayOfYear 등) 설정가능
- isBefore, isAfter => 날짜 비교 가능

LocalDateTime - 날짜와 시간을 모두 보여줌
LocalTime - 시간만 보여줌

