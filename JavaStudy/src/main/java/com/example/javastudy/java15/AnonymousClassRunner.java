package com.example.javastudy.java15;

import java.util.*;

class LengthComparator implements Comparator<String>{

    @Override
     public int compare(String o1, String o2) {
        return Integer.compare(o1.length(),o2.length());
    }
}
public class AnonymousClassRunner {



    public static void main(String[] args) {

        List<String> animals = new ArrayList<String>(List.of("Ant", "Elephant","Ball", "Cat"));

        animals.add("ABC");

//        Collections.sort(animals,new LengthComparator());
        Collections.sort(animals,
                new Comparator<String>() { // 익명 클래스
                    @Override
                    public int compare(String o1, String o2) {
                        return Integer.compare(o1.length(), o2.length());
                    }
                });
        System.out.println(animals);

//        Comparator<? super String> Predicate= (a1,a2)->Integer.compare(a2.length(),a1.length());
//        animals.stream().sorted(Predicate).forEach(System.out::println);
    }

    private static int compare(String a1, String a2) {
        return Integer.compare(a1.length(), a2.length());
    }
}
