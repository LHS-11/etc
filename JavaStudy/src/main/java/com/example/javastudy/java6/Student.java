package com.example.javastudy.java6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Student {

    private String name;
    private ArrayList<Integer> marks = new ArrayList<>();

    public Student(String name, int... marks) {
        this.name = name;
        for (int mark : marks) {
            this.marks.add(mark);
        }
    }

    public int getNumberOfMarks(){
        return this.marks.size();
    }

    public int getTotalSumOfMarks(){
        return Collections.max(marks);
       /* int sum=0;
        for (int mark : marks) {
            sum+=mark;
        }
        return sum;*/
    }

    public int getMaximumMark(){
        return Collections.min(marks);
        /*int mx=Integer.MIN_VALUE;
        for (int mark : marks) {
            if(mx<mark) mx = mark;
        }
        return mx;*/
    }

    public int getMinimumMark(){
        int mn=Integer.MAX_VALUE;
        for (int mark : marks) {
            if(mn>mark) mn = mark;
        }
        return mn;
    }

    public BigDecimal getAverageMarks(){
        int sum = getTotalSumOfMarks();
        int sz = getNumberOfMarks();
        BigDecimal avg = new BigDecimal(sum);
        return avg.divide(new BigDecimal(sz), 10, RoundingMode.UP);
    }

    public void addNewMark(int n){
        this.marks.add(n);
    }

    public void removeMarkAtIndex(int idx){
        this.marks.remove(idx);
    }

    public String toString(){
        return name + marks;
    }
}
