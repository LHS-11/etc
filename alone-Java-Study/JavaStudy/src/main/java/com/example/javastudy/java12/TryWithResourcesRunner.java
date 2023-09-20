package com.example.javastudy.java12;

import java.util.Scanner;

public class TryWithResourcesRunner {
    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) { // 오류가 생기면 알아서 close 해줌
            int[] arr = {12, 3, 4, 5};
            int a = arr[3];

        }
    }
}
