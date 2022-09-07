특정 타입이 아닌 여러 타입을 받고 싶을때 Generics 이용
클래스에 제네릭 생성
ex) public class MyCustomList<T>{
    ArrayList<T> list=new ArrayList<>();

}
메서드에 제네릭 생성
ex)
static <X> X doubleValue(X value){ // 어떤 값도 출력 가능
        return value;
}
static <X extends List> void duplicate(X list){ // List 계열만 ArrayList, Vector, LinkedList
        list.addAll(list);
}

Number -> Integer, Double, Float, Byte, Int, Long, Short

상한 경계 와일드 카드 => Number 클래스를 연장하는 Number 클래스의 하위 클래스인 모든 리스트들에 대해 공통된 논리를 구현하는데 도움
ex)
static Double sumOfNumberList(List<? extends Number> list){  => ? : 와일드 카드
        double sum=0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
}

하한 경계 와일드 카드 => 숫자의 하위 타입들의 여러 다른 값들을 많이 추가 가능하게 해줌
ex)
static void addCoupleOfValues(List<? super Number> list){
        // 숫자 클래스의 하위 클래스인 이상 아무 종류나 list 에 추가 가능
        list.add(1);
        list.add(1.0);
        list.add(2L);

}