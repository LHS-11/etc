package com.example.javastudy.java1;

public class MotorBikeRunner {
    public static void main(String[] args) {
        MotorBike honda = new MotorBike();
        MotorBike ducati = new MotorBike(200);

        System.out.println(honda.getSpeed());
        System.out.println(ducati.getSpeed());
    }
}
