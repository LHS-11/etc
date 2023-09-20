자바의 파일과 디렉토리

파일들을 목록으로 정리하는 메서드
=> Files.list(경로)
ex)public class DirectoryScanRunner {
       public static void main(String[] args) throws IOException {
           Files.list(Paths.get(".")).forEach(System.out::println);
       }
   }

전체 디렉토리를 가져오고 싶을 때 (재귀적인 방법)
=> Files.walk(경로)

원하는 파일을 찾는 메서드
=> Files.find(경로,깊이,람다식)
파일의 attributes 들을 기준으로 필터링하여 디렉토리가 맞는지, 크기가 얼마만한지등 여러가지 알 수 있음
파일의 이름이나 path, 파일의 특성에 따라 필터링 하는 것이 가능

파일에서 내용 불러오는 메서드
=> Files.readAllLines(경로)
모든 줄의 내용을 리스트 형식으로 한번에 출력 but 큰 용량의 파일을 다룰 땐 좋은 방법이 아님
So Files.lines(경로) => Stream 이용 (filter, map 같은 다양한 연산 사용 가능)

파일에 내용 담기
=> Files.write(경로,담을 내용)