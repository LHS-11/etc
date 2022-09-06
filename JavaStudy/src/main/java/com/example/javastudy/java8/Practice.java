package com.example.javastudy.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Practice {

    public static void main(String[] args) {

        String str = "This is an awesome occasion. This has never happened before.";
        char[] chars = str.toCharArray(); // 문자열을 문자 배열로 다 가져올 수도 있음
        String[] words = str.split(" "); // 띄어쓰기를 없애고 문자들을 String 베열에 담아줌

        Map<Character, Integer> mp = new HashMap<>();
        Map<String, Integer> mp1 = new TreeMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (mp.containsKey(str.charAt(i))){
                int cnt = mp.get(str.charAt(i));
                mp.put(str.charAt(i), cnt + 1);
            }else {
                mp.put(str.charAt(i),1);
            }
        }
        System.out.println("mp.toString() = " + mp);

        String s = "";
        for(int i=0;i<str.length();i++){
            s+=str.charAt(i);
            if(str.charAt(i)==' '){
                if (mp1.containsKey(s)){
                    int cnt = mp1.get(s);
                    mp1.put(s, cnt + 1);
                }else {
                    mp1.put(s,1);
                }
                s = "";
            }
        }
        System.out.println("mp1.toString() = " + mp1.toString());

    }
}
