package com.example.javastudy.java14;

public class Counter {
    int i=0;
    synchronized public void increment(){ // 동기화 되어 있지 않다면 여러개의 쓰레드가 increment 메서드를 사용할 때 제대로 업데이트가
        // 이루어지지 않는다 따라서 synchronized 를 붙어야 한다
        i++;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
