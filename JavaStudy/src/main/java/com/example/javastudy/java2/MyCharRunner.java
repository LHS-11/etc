package com.example.javastudy.java2;

public class MyCharRunner {
    public static void main(String[] args) {

        MyChar myChar = new MyChar('c');

        System.out.println("myChar.isNumber() = " + myChar.isNumber());

        myChar.printLowerCaseAlphabets();
        myChar.printUpperCaseAlphabets();
    }
}
