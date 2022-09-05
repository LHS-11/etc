package com.example.javastudy.java7;

public class Rectangle {
    private int width;
    private int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public String toString(){
        return "width - " + width + ", length - " + length;
    }
}
