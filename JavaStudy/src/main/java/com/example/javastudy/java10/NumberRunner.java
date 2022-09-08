package com.example.javastudy.java10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberRunner {

    public static void main(String[] args) {
//        List<Integer> list = List.of(1, 2, 3, 4, 5);

//        Integer sum = list.stream().reduce(0, (num1, num2) -> num1 + num2);

//        Integer sum1 = fpSum(list);

//        System.out.println("sum = " + sum);

//        System.out.println("sum1 = " + sum1);

        List<Integer> numbers = List.of(3, 5, 8, 213, 45, 4, 7);
        List<String> list = List.of("Apple", "Bay", "Ant");


        IntStream.range(1,10).forEach(ele-> System.out.println(ele));
        list.stream().map(ele->ele.toLowerCase()).forEach(ele-> System.out.println(ele));
        list.stream().map(ele->ele.length()).forEach(ele-> System.out.println(ele));
        list.stream().map(ele->ele.length()).forEach(System.out::println);


    }

    private static Integer fpSum(List<Integer> list) {
        return list.stream().filter(ele -> ele % 2 == 1).reduce(0, (num1, num2) -> (num1 + num2));
    }
}
