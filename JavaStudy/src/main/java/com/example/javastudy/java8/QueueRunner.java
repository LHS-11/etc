package com.example.javastudy.java8;

import java.util.*;


class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
    }
}
public class QueueRunner {

    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>(new StringLengthComparator());
        pq.addAll(List.of("dede", "apple", "zebraaaa"));
//        System.out.println("pq = " + pq.poll());

        Map<String, Integer> mp = Map.of("F", 25,"A", 15, "Z", 5, "L", 250);
        System.out.println("mp.toString() = " + mp.toString());
        LinkedHashMap<String, Integer> lmp = new LinkedHashMap<>(mp);
        System.out.println("lmp.toString() = " + lmp.toString());
        TreeMap<String, Integer> tmp = new TreeMap<>(mp);
        System.out.println("tmp.toString() = " + tmp.toString());
    }
}
