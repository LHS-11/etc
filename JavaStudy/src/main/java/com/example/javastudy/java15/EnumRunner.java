package com.example.javastudy.java15;


import java.time.DayOfWeek;
import java.time.Month;

public class EnumRunner {
    public static void main(String[] args) {

        Season season = Season.FALL;

        Season season1 = Season.valueOf("WINTER");
        System.out.println(season1.name());
        System.out.println(season1.getValue());

        DayOfWeek.valueOf("MONDAY");
        DayOfWeek monday = DayOfWeek.MONDAY;
        Month august = Month.AUGUST;

        System.out.println(Month.of(11));
    }
}
