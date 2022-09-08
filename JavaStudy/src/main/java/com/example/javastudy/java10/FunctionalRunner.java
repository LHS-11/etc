package com.example.javastudy.java10;

import java.util.List;

public class FunctionalRunner {

    public static void main(String[] args) {
        List<String> list = List.of("Apple", "Bat", "Cat", "Dog");

        printWithFP(list);

        printWithFPWithFiltering(list);
    }

    private static void printWithFPWithFiltering(List<String> list) {
        list.stream().filter(ele -> ele.endsWith("at")).forEach(
                ele -> System.out.println("ele = " + ele)
        );
    }

    private static void printWithFP(List<String> list) {
        list.stream().forEach(
                element-> System.out.println("element = " + element) // 람다 표현
        ); // forEach에 함수 코드를 보내는 것
    }
}
