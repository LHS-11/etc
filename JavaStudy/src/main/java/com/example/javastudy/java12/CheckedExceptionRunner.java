package com.example.javastudy.java12;

public class CheckedExceptionRunner {

    public static void main(String[] args) {
        try{
            someOtherMethod();
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void someOtherMethod() throws Exception {

        Thread.sleep(10000);
    }
}
