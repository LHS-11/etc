package com.example.javastudy.java2;

public class BiNumber {

    private int number1;
    private int number2;

    public BiNumber (int a,int b){
        this.number1 =a;
        this.number2 =b;
    }

    public int add(){
        return this.number1 + this.number2;
    }

    public int multiply(){
        return this.number1 * this.number2;
    }

    public void doubleValue(){
        this.number1 *=2;
        this.number2 *=2;
    }

    public int getNumber1(){
        return this.number1;
    }

    public int getNumber2(){
        return this.number2;
    }
}
