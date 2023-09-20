package com.example.javastudy.java8;

import java.util.*;

public class SetRunner {

    public static void main(String[] args) {
        List<Character> list = List.of('A', 'Z', 'B','A');
        Set<Character> treeSet = new TreeSet<>(list);
        for (Character character : treeSet) {
//            System.out.println("character = " + character);
        }

        Set<Character> linkedList = new LinkedHashSet<>(list);
        for (Character character : linkedList) {
//            System.out.println("character = " + character);
        }

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        System.out.println("queue = " + queue.poll());
        System.out.println("queue = " + queue.size());


    }
}
