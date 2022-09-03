package com.example.javastudy.java3_4;

import java.util.Scanner;

public class MenuRunner {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number1: ");
        int number1 = scanner.nextInt();

        System.out.println("Enter Number2: ");
        int number2 = scanner.nextInt();

        System.out.println("Enter Choice: ");
        int choice = scanner.nextInt();

        switch (choice) {

        }*/
        MyNumber myNumber = new MyNumber(6);
        System.out.println("myNumber.isPrime() = " + myNumber.isPrime());
        System.out.println("myNumber.sumOfDivisors() = " + myNumber.sumOfDivisors());
        myNumber.printANumberTriangle();


    }
}
