static imports
ex)
import static java.lang.System.out;
=> System.out.println() -> out.println() 가능
import static java.util.Collections.*;
=> Collections.sort() -> sort() 가능

block
=> if 문에서만 사용되는 것이 아님, block 을 지정하고 그 안에 변수를 선언하면 그 block 안에서만 유효
ex) {
 int i;
}

equals
=> 객체가 같을 때만 true, 안에 정보가 같다고 같은게 아님 (서로 다른 메모리에 위치)

hashcode
=> hashcode 를 기준으로 bucket 에 배정
=> equals() 메서드를 실행할 때 hashCode() 메서드도 실행해야함

클래스 접근 제어자
public - 클래스가 public 에 해당한다면 다른 패키지의 클래스에서도 사용 가능
default - 클래스가 (default) 의 경우 해당 패키지 안에서만 사용 가능
protected, private 은 클래스에 사용 불가능

메소드 접근 제어자
public - 오로지 public 만 다른 패키지에서도 접근 가능
default - 같은 패키지이거나 자식 클래스(상속)에서 접근 가능
private - 같은 패키지 안에서 접근 불가능 (오로지 같은 클래스 안에서만 접근 가능)
protected - 같은 패키지이거나 해당 클래스에서만 접근 가능

final 클래스, final 메서드
final 클래스 - 상속 불가능 (extends X), 특정 클래스에 대한 확장을 허용하고 싶지 않을 때 사용
final 메서드 - 코드 오버라이딩 불가능

final 변수, final 전달인자
final 변수 - 불변성을 가짐 (값이 고정되길 원할 때), 단 한번만 값 부여 가능 (but, 생성자를 통해 인스턴스 마다 값을 달리 할 수 있다.)
final 전달인자 - final 을 이용해서 값을 받을 때 전달인자 수정 불가능

static 변수
static 변수 - 다수의 인스턴스 사이에서 공유 가능 (각 인스턴스에 대해 별도의 인스턴스를 갖는 상황이 아닌 하나의 인스턴스만 갖길 원할 때)
ex) Player 클래스에서 인원수를 카운팅 할 때 static 이용하면 인스턴스를 생성할 때마다 카운팅이 됨

static 메서드
=> 인스턴스 없이 클래스 이름에서 static 메서드 바로 사용 가능

static 메서드 안에서는 인스턴스 데이터에 접근 불가능 (static 인 데이터만 접근 가능)
<-> 반대는 가능

public static final 변수 - 상수 (정의)
=> 작업을 좀 더 분명하고 쉽게 전달
public final 변수와 차이점 : 그저 final 만 선언한 변수의 경우 생성자를 통해서 인스턴스마다 값을 변경할 수 있다.
but public static final 은 가능하지 않다.

중첩 클래스 - 내부 클래스 vs 정적 중첩 클래스
내부 클래스들(nested classes) 은 다른 클래스 안에 들어가 있는 class 를 말함
전체 클래스의 선언이 다른 클래스 안에서 이루어짐
내부 클래스는 외부 클래스의 인스턴스가 필요 하지만 정적 중첩 클래스는 외부 클래스의 인스턴스가 필요 없다
but 내부 클래스는 외부 클래스의 멤버 변수에 접근 할 수 있지만, 정적 중첩 클래스는 불가능

익명 클래스 => 다른 곳에서 사용되면 안됨. ( 이 논리가 여기에만 쓰인다는 것을 확신할 때 사용)
ex)
 Collections.sort(animals,
                new Comparator<String>() { // 익명 클래스
                    @Override
                    public int compare(String o1, String o2) {
                        return Integer.compare(o1.length(), o2.length());
                    }
                });

Enum (열거형) => 특정 값에 제한을 두기 위해서 사용
열거형 , 인스턴스 변수에 저장 가능
ex)
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

