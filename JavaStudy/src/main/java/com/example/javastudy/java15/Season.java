package com.example.javastudy.java15;

public enum Season{
    WINTER(4), SPRING(1),SUMMER(2), FALL(3);

    private int value;
    private Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}