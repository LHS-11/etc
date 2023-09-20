package com.example.javastudy.java9;

import java.util.*;

public class GenericsRunner {

    //X 임의의 제네릭 타입
    static <X> X doubleValue(X value){ // 어떤 값도 출력 가능
        return value;
    }

    static <X extends List> void duplicate(X list){ // List 계열만 ArrayList, Vector, LinkedList
        list.addAll(list);
    }

    //상한 경계 와일드 카드
    static Double sumOfNumberList(List<? extends Number> list){
        double sum=0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    //하한 경계 와일드 카드
    static void addCoupleOfValues(List<? super Number> list){
        // 숫자 클래스의 하위 클래스인 이상 아무 종류나 list 에 추가 가능
        list.add(1);
        list.add(1.0);
        list.add(2L);

    }

    public static void main(String[] args) {
        MyCustomList<Integer> myCustomList = new MyCustomList();

        myCustomList.addElement(1);
        myCustomList.addElement(2);
        int value= myCustomList.get(0);
//        System.out.println("myCustomList.toString() = " + myCustomList.toString());
        TreeSet treeSet = new TreeSet();
        treeSet.add(1.0);
        treeSet.add(2.0);
        System.out.println(treeSet);

        System.out.println(doubleValue(new ArrayList(List.of(1,1.0,2l))));
        System.out.println(doubleValue(new ArrayList(List.of(1, 2, 3))));
        System.out.println(doubleValue("123"));
        System.out.println(doubleValue(123));
        System.out.println(doubleValue(20L));

        List<Number> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        addCoupleOfValues(list1);
        System.out.println(list1);


    }
}
