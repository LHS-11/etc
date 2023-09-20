package com.example.javastudy.java1;

public class MotorBike {

    private int speed;
    private String gear;

    public MotorBike(int speed){
        this.speed = speed;
    }

    public MotorBike(){
        this(5);
    }

    public void start(){
        System.out.println("Bike Start!");
    }

    public void increaseSpeed(int howMuch){
       setSpeed(this.speed+=howMuch);
    }

    public void decreaseSpeed(int howMuch){
        setSpeed(this.speed-howMuch);
    }

    public void setSpeed(int speed) {
        if(speed>0) this.speed = speed;

    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public String getGear() {
        return gear;
    }
}
