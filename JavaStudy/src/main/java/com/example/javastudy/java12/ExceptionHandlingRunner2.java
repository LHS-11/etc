package com.example.javastudy.java12;

public class ExceptionHandlingRunner2 {

    public static void main(String[] args) {
            method1();
    }

    private static void method1() {
        try {
            method2();

        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void method2() {
        String s = null;
        s.length();
    }
}
