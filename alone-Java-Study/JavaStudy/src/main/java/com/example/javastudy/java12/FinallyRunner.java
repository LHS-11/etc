package com.example.javastudy.java12;

import java.util.Scanner;

public class FinallyRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            int[] arr = {12, 3, 4, 5};
            int a = arr[5];
        }catch (Exception e){

        }finally { // 예외가 생기든 안생기든 finally 블럭 코드 실행 (무조건 절대적 return 값이 try 문에 있어도 실행됨)
            scanner.close(); // scanner 를 사용한 후에 scanner 를 닫아줘야함 ( so 리소스 유출 막음 )
        }

    }
}
