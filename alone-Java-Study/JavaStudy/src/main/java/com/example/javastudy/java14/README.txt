동시 컬렉션의 동시성과 활용한 원자 연산

concurrency

counter

automic operation

thread-safety => 임의의 메소드가 다양한 thread 에 의해 한 번에 안전하게 실행되는 것

not thread-safe -> synchronized 를 붙이면 됨
-> 문제점 : 적은 병행성을 가짐 ( 동기화(synchronized)된 메서드들이 여러개일 경우 각 메서드가 독립성을 가져도 여러 thread 들이 대기하는 상황이 생길 수 있음)
=> Lock 를 사용시 코드를 synchronized 없이도 동기화해주거나 thread-safe 하게 해줌
( locks => 동기화된 코드를 여러 조각의 코드로 쪼갤 수 있게 해줌 )

atomic class
=> AtomicInteger
AtomicInteger 에 의존하여 thread-safe 한지를 확인하게 됨 ( locks 에 의무를 가져와서 AtomicInteger 에 부여)
아무곳이나 사용 X => 다양한 연산의 과정들이 필요할 경우 AtomicInteger 보단 lock 사용

ConcurrentHashMap => 해당 인터페이스에 computeIfAbsent() 메서드가 있는데 이 메서드가 atomic 연산을 보장해줌
so ConcurrentHashMap 을 불러내는 순간 thread-safe 에 해당
ConcurrentHashMap 은 지역을 나눠서 각 지역마다 다른 lock 를 사용해서 자원을 조금 더 효율적으로 사용 가능하게 함

CopyOnWrite
=> write 가 매우 적고, read 가 매우 많은 경우에 효율적
=> 수정시 array 전체를 복사 (복사하는 동안 그 전의 array 를 이용함)
=> 동시성 (Concurrency) 확보


