Collections

List<String> words = List.of("Apple","Bat","Banana"); => 한번에 리스트 구성 (하나씩 add 할 필요없이)

words.get(0) => "Apple"

words.contain("Bat") => true

words.indexOf("Banana") => 2
words.indexOf("A") => -1

불변성 => 특정 클래스의 인스턴스를 만든 순간부터 이 값을 변경 X
ex) String , BigDecimal, Wrapper, List

List (불변성) <-> ArrayList, LinkedList, Vector (가변성)
ex) List<String> words = List.of("Apple","Bat","Banana") => 불변성 (List.of로 구성)
List<String> words=new ArrayList<String>() => 가변성
List<String> words=new LinkedList<String>()
List<String> words=new Vector<String>()

배열의 경우 삽입과 삭제에 비효율 but 접근성은 좋음
LinkedList 의 경우 삽입과 삭제에 효과적 but 접근성은 비효율

Vector 가 Thread Safe (Synchronized Methods) => 성능 구림
안전이 필요하지 않으면 ArrayList 쓰자

ArrayList.add(index, n) => index 에 n 삽입
ArrayList.addAll()
ArrayList.set(index, n) => index 의 값을 n으로 변경
ArrayList.remove(index) => index 의 값을 제거

ex)
Iterator wordsIterator=words.iterator();
while(wordsIterator.hasNext()){
    System.out.println(wordsIterator.next());
}

특정 원소를 제거시
ex) List<String> words=List.of("Apple","Cat","Bat");
List<String> wordAl=new ArrayList<>(words);

Iterator<String> iterator=wordsAl.iterator();
while(iterator.hasNext()){
    if(iterator.next().endsWith("at")){
        iterator.remove();
    }
}
wordAl=> [Apple]

List value=List.of("A",'A',1,1.0)
=> List 에서 type 에 상관없이 담을 수 있음 -> 특정한 type 만 담고 싶다면 Generation (일반화)

Collections.sort(객체 이름) => 정렬

ArrayList.sort()

--------------------------------------------------------------------
Set 인터페이스 => 중복 X

Set, HashSet 은 요소의 친구 상관 안함 (순서대로 저장 X, 정렬 X)
<-> LinkedHashSet 은 순서대로 저장
<-> TreeSet 은 정렬됨

Set 특정 위치에 요소를 추가하거나 제거 X

Hashing 함수의 경우 13을 나눈 나머지 값을 index 로 가짐
=> 해시코드라는 것을 이용해 구현

Tree(red-black tree) => 검색, 제거, 삽입의 소모성을 줄여주는데 효과적

TreeSet.floor(n) => n보다 작거나 같은 것
TreeSet.lower(n) => n보다 작은 것
TreeSet.ceiling(n) => n보다 크거나 같은 것
TreeSet.subSet(a,b) => a보다 크거나 같고 b보단 작다
TreeSet.subSet(a,True,b,True) => a보다 크거나 같고 b보단 작거나 같다
TreeSet.headSet(n) => n 이전의 모든 숫자 출력
TreeSet.tailSet(n) => n 부터 모든 숫자 출력

queue
Queue.poll() => 맨 앞에 요소를 꺼내고 출력
Queue.offer() => 요소 추가
Queue.addAll(List.of()) => 여러 요소 추가

class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
    }
}
----------------------------------------------------------------------

HashMap => key 값을 null 값과 저장 가능

HashTable => 해싱함수 사용, 동기화 (스레드 안전 => 스레드가 작업을 하고 있으면 그 작업이 끝날 때까지 기다림 so 성능은 안좋음)

map <-> HashMap, HashTable <-> LinkedHashMap <-> TreeMap

.of() => 이용해서 만들면 불변성을 지님 (추가 안됨)

Map.containsKey()
Map.containsValue()
Map.keySet()
Map.values()

TreeMap - NavigableMap
TreeMap.higherKey(n) => n보다 큰 key 값
TreeMap.lowerKey(n) => n보다 작은 key 값

TreeMap.ceilingKey(n) => n보다 같거나 큰 key 값
TreeMap.floorKey(n) => n보다 같거나 작은 key 값

TreeMap.firstEntry() => 처음 값
TreeMap.lastEntry() => 마지막 값

TreeMap.subMap(a,b) => a보다 같거나 크고, b보다 작은 key,value 값
