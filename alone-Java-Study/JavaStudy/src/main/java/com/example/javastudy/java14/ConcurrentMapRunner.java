package com.example.javastudy.java14;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentMapRunner {

    public static void main(String[] args) {

        Map<Character, LongAdder> occurances = new ConcurrentHashMap<>();

        String str = "ABCD ABCD ABCD";

        for (char c : str.toCharArray()) {
            // thread-safety 코드
            occurances.computeIfAbsent(c,ch->new LongAdder()).increment();
            //not thread-safety 코드
//            LongAdder longAdder = occurances.get(c);
//            if(longAdder==null){
//                longAdder = new LongAdder();
//            }
//            longAdder.increment(); // longAdder 를 사용하는 이유 자동 증가 연산을 제공해주기 때문
//            occurances.put(c, longAdder);
        }
        System.out.println(occurances);

    }
}
