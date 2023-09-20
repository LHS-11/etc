package com.example.javastudy.java3_4;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("dayNumber input: ");
        int dayNumber = scanner.nextInt();
        isWeekDay(dayNumber);
    }

    public static String isWeekDay(int dayNumber){
        String result="";
        switch (dayNumber){
            case 0:
                result = "Sunday";
                break;
            case 1:
                result = "Monday";
                break;
            case 2:
                result = "Tuesday";
                break;
            case 3:
                result = "Wednesday";
                break;
            case 4:
                result = "Thursday";
                break;
            case 5:
                result = "Friday";
                break;
            default:
                result = "Saturday";
                break;
        }
        return result;
    }
}
