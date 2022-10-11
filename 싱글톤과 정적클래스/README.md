## Singleton 이란?
=> 클래스의 인스턴스를 하나만 생성하고, 어디서든 그 인스턴스를 참조할 수 있도록 하는 패턴
=> 생성자가 여러 번 호출해도 실제로 생성되는 객체는 하나

### 싱글톤을 쓰는 이유
- 고정된 메모리 영역을 가지고 하나의 인스턴스만 사용하기 때문에 메모리 낭비 방지
- 싱글톤 클래스의 인스턴스는 전역이기 때문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉬움
- DBCP (Database Connection Pool)처럼 공통된 객체를 여러 개 생성해야 하는 상황에 많이 사용

## 싱글톤 구현
1. Eager initialization
```
public class EagerSingleton{
	private static EagerSignleton instance=new EagerSingleton();
    
    private EagerSingleton(){
    }
    
    public static EagerSingleton getInstance(){
    	return instance;
    }
		
}
```
장점 : 속도가 빠름
단점 : 클라이언트에서 사용하지 않더라도 인스턴스가 항상 생성됨(메모리 낭비), 예외처리 할 수 있는 방법이 없음

2. Static block initialization
```
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    static{
        try{
            instance = new StaticBlockSingleton();
        }catch (Exception e){
            throw new RuntimeException("싱글톤 객체 생성 오류");
        }
    }

    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
```
장점 : initialization과 유사하지만 인스턴스가 static block 안에서 생성돼서 예외 처리 가능
단점 : 여전히 처음에 인스턴스가 생성됨

  3. Lazy initialization
```
public class LazyInitializationSingleton {

    private static LazyInitializationSingleton instance;

    private LazyInitializationSingleton(){}

    public static LazyInitializationSingleton getInstance(){
        if (Objects.isNull(instance)) {
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }
}
```

장점 : getInstance() 호출 이외에 인스턴스를 생성하지 않음, Eager initialization의 단점을 보완
단점 : Non Thread Safe

4. Thread safe initialization
```
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static synchronized ThreadSafeSingleton getInstance(){
        if (instance==null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
```
장점 : Thread Safe ( Synchronized 이용해서 하나의 스레드만 접근 가능하도록 설정 )
단점 : 성능이 비효율적

5. Double-Checked Locking
```
public class DoubleCheckedLockingSingleton {

    private static DoubleCheckedLockingSingleton instance=null;

    private DoubleCheckedLockingSingleton(){}

    public static DoubleCheckedLockingSingleton getInstance(){
        if (Objects.isNull(instance)) {
            synchronized (DoubleCheckedLockingSingleton.class){
                instance = new DoubleCheckedLockingSingleton();
            }
        }
        return instance;
    }
}
```

Null 체크를 synchronized 블록 밖에서 한번, 안에서 한번 총 두 번 실행 밖에서 하는 체크는 인스턴스가 있는 경우 빠르게 리턴하기 위해서 안쪽에서 하는 체크는 인스턴스가 생성되지 않는 경우 하나의 인스턴스만 생성하기 위해서

6. Bill Pugh Solution
```
public class BillPughSingleton {

    private static BillPughSingleton instance=null;

    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
```

Double Checked 에 비해 구현이 간단
Lazy Loading이 가능, Thread Safe


## 정적 클래스란?
=> 모든 메소드가 static인 클래스를 지칭
=> inner static class를 뜻하기도 함

### 정적 클래스를 쓰는 이유
- 상태를 가지고 있지 않고 global access 를 제공할 때 유용
- Static은 컴파일 할 때 static binding 으로 싱글톤보다 좀 더 빠름
- 클래스 자체에 static 을 붙여 사용할 수 없음 (inner class일 때만 가능)

1. Static Variable
- 메모리에 고정적으로 할당되어, 프로그램이 종료될 때 해제되는 변수

2. Static Method
- 객체 생성 없이 메소드 바로 호출 가능
- 객체 생성 없이 접근하는 메소드이므로 static이 아닌 변수는 사용 불가능

3. Static Class
- Static Nested Class
- 외부클래스 자원 중 static 이 붙은 것만 사용 가능

### 싱글톤과 정적 클래스의 차이
- 싱글톤은 인스턴스를 가지지만 정적 클래스는 인스턴스를 가지지 않음 
(싱글톤 OOP 지향 O, 정적 클래스 OOP 지향 X)
- 싱글톤은 인터페이스 구현 가능하지만 정적 클래스는 안됨
- 싱글톤은 상속이 되지만 정적 클래스는 안됨
- 싱글톤은 필요에 따라 Lazy 가능, 정적 클래스는 Static Binding 으로 빠르게 로딩

### 싱글톤은 OOP 일까?
- 싱글톤이 상태를 가지는 객체일 경우 전역으로 접근 하는 여러 다른 쓰레드에서 상태를 바꾸게 되는 위험성이 존재, 생성자에서 의존성이 드러나지 않음 
=> 상태가 없는 객체나 설계 상 유일해야 하는 시스템 컴포넌트를 싱글톤으로 구현

### 싱글톤은 안티패턴이 아닌가?
- 대부분의 싱글톤의 경우 인터페이스가 아닌 클래스의 객체를 미리 생성하고 정적 메소드를 이용해 사용
=> 싱글톤과 사용하는 클래스 사이에 강한 의존성, 높은 결합이 생기게 되어 수정, 단위테스트의 어려움이 발생
  - 어떻게 해결해야 하나? 
  => 종속성 주입 (DI)를 이용하여 객체를 관리, 가장 이상적인 방법은 설계를 통해 하나의 인스턴스만 존재하도록 관리하는 것
  => 모든 싱글톤 객체를 관리하기는 쉽지 않음 -> Spring Framework 가 대신 도와줌 (IoC 방식의 컨테이너에게 넘겨 컨테이너가 관리)
  
------------------------------------------------------------
우아한Tech의 테코톡(크로플님의 싱글턴과 정적클래스)를 참조하였습니다.