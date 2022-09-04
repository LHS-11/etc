배열 선언
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

가변 인수 => 인수에 갯수 제한없이 여러개를 받을 수 있음, 무조건 마지막 인수여야함!
ex) void print(int... values){
    System.out.println(Arrays.toString(values));
}

ex)
Student[] student=new Student[5];
student[1]=new Student();
Student[] student2={new Student(),new Student()};
String[] string={"apple","banana","kiwi"}

Array 를 한번 만들면 크기 수정 안됨 => 새로운 Array 만들어서 거기다 추가하거나 삭제 해야함 -> ArrayList를 사용하면 해결 가능

ArrayList
String 타입의 ArrayList 를 생성시
=> ArrayList<String> items=new ArrayList<String>();

ArrayList 는 Collection 의 일부이기 때문에 Collection 메소드 사용 가능
Collections.max(marks)

toString() => 객체명 출력시 해시 값이 나오는데, toString 메서드가 있다면 그 객체의 값(정보)가 나옴
public String toString(){
    return
}