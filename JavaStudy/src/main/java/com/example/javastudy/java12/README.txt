Exception Handling ( 예외 처리 ) 2 가지 키

1. 제가 이용하려는 시스템의 최종 사용자에게 친절하게 메시지를 남기는 것 (어떤 작업 또는 단계를 거쳐야 하는지 알림)
2. 오류를 제거하기 위한 충분한 정보를 제공

call chain

try ~catch

예외에서 서열 존재
Exception > RuntimeException > NullPointException

finally
=> 예외가 생기든 안생기든 finally 블럭 코드 실행 (무조건 절대적 return 값이 try 문에 있어도 실행됨)
but System.exit 의 경우에는 실행 X

try 는 단독으로 쓰일 수 없다. (무조건 catch 나 finally 와 같이 쓰여야함)

점검 예외 처리 vs 비점검 예외 처리

class Error extends Throwable => Error 는 프로그래머가 처리할 수 없는 오류 (메모리를 모두 사용한 경우, JVM 메모리, stack overflow 에러등)
class Exception extends Throwable => Exception 는 프로그래머가 처리 할 수 있는 오류

Exception 항목 아래 RuntimeException 이 아닌 것들이 checked exceptions ( 처리하기 까다로운 것들)
=> calling 메서드가 이를 처리하거나 또 다시 떠넘기는 방법 사용
=> 예외를 처리해줘야함
=> throws 를 앞에 붙여줘야함

RuntimeException => unchecked exception ( calling 메서드가 아무 처리 안해도 됨 => 예외를 밖으로 던지는 것을 걱정할 필요 없다)

if) 소비자가 예외를 처리할 수 있다면 (예외가 생겼다는 것을 알리길 바란다면) checked exception => 사용자에게 압박을 줌
소비자가 대응할 수 없는 일이라면 RuntimeException 을 사용

try-with-resources => try( ) 기능을 자료들에 사용 (구체적인 상황이라서 catch 나 finally 불필요 )
ex) public class TryWithResourcesRunner {
        public static void main(String[] args) {

            try(Scanner scanner = new Scanner(System.in)) { // 오류가 생기면 알아서 close 해줌
                int[] arr = {12, 3, 4, 5};
                int a = arr[3];

            }
        }
    }

두개 이상의 예외를 한번에 다룰 수도 있음
catch ( IOException | SQLException ex) {
 ex.printStackTrace();
}

예외를 다루는데 있어서 최고의 방법들
1. 예외를 숨기지 말자 => stack trace 의 전부를 log 에 넣음
2. flow control 사용 X => if-else 사용 X
3. 사용자를 생각하라 => 최종 사용자에게 어떻게 설명 할지를 생각하라
4. calling 메서드에 대해 생각하라 => RuntimeException으로 만들 필요가 없는지 생각
5. global exception handling => 모든 것을 관장하는 무언가를 설정 (사용자에게 예외가 직접 전달되는 일이 없도록) -> 예외에 대한 올바른 메시지가 출력되어야 함