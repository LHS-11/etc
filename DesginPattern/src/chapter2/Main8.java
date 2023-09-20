package chapter2;

public class Main8 {

    public static void main(String[] args) {
        ArrayStack st = new ArrayStack(10);
        st.push(10);
        System.out.println(st.peek()); // pop 를 사용하지 않고 직접 배열에 접근 가능 -> 강한 결합이 생김
    }

}
