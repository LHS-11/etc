package com.example.javastudy.java8.collections;

import java.util.*;

class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
public class Runner {
    public static void main(String[] args) {
        List<Student> students = List.of(new Student(111, "paul"), new Student(2, "James"), new Student(23, "adams"));
        List<Student> studentsAl = new ArrayList<>(students);

        Collections.sort(studentsAl);
        System.out.println("studentsAl = " + studentsAl);
        Collections.sort(studentsAl, new StudentComparator());
        System.out.println("studentsAl = " + studentsAl);


    }
}
