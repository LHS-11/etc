package com.example.javastudy.java7;

public class FanRunner {

    public static void main(String[] args) {
        Fan fan = new Fan("Manufacturer 1", 0.34567, "Green");
        fan.switchOn();
        System.out.println("fan = " + fan); // 패키지 이름, 클래스, 메모리 해시코드
        fan.setSpeed((byte) 3);
        System.out.println("fan = " + fan); // 패키지 이름, 클래스, 메모리 해시코드
        fan.switchOff();
        System.out.println("fan = " + fan);

    }
}
