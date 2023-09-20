package chapter7.refactor1;

public class Mainsw {

    public static void main(String[] args) {

        OFF off = OFF.getInstance();
        System.out.println(off);
        OFF off1 = OFF.getInstance();
        System.out.println(off1);

        System.out.println(ON.getInstance());
        System.out.println(ON.getInstance());

    }
}
