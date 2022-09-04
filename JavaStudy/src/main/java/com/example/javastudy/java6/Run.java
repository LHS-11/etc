package com.example.javastudy.java6;

import java.util.ArrayList;

public class Run {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(); // 35 +41  => 76
        arr.add(10);
        arr.add(20);
        Student student = new Student("paul",10,20);
//        Student student = new Student("paul", new int[]{97, 98, 100});
//        System.out.println("student.getNumberOfMarks() = " + student.getNumberOfMarks());
//        System.out.println("student.getAverageMarks() = " + student.getAverageMarks());

        student.addNewMark(23);

        System.out.println(student);

        student.removeMarkAtIndex(1);

        System.out.println(student);

        String[] days = {"Sunday", "Monday", "Tuesday","Wednesday", "Thursday", "Friday", "Saturday"};
        int dayLetter=days[0].length();
        int dayIdx=0;
        for (int i=0;i<days.length;i++) {
            if(dayLetter<days[i].length()) {
                dayLetter=days[i].length();
                dayIdx=i;
            }
        }
        System.out.println("days[dayIdx] = " + days[dayIdx]);

        for(int i=days.length-1;i>=0;i--){
            System.out.println("days = " + days[i]);
        }
    }
}
