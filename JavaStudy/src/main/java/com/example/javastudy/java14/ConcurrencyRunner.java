package com.example.javastudy.java14;

public class ConcurrencyRunner {
    public static void main(String[] args) {
        Counter counter = new Counter();

        counter.increment();

        System.out.println(counter.getI());
    }
}
