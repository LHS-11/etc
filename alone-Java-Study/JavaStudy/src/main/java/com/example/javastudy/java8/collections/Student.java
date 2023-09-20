package com.example.javastudy.java8.collections;

public class Student implements Comparable<Student>{
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "age- [" + age + "] name - [" + name + "]";
    }


    @Override
    public int compareTo(Student that) {
//        return Integer.compare(this.age, that.age); // 오름차순
        return Integer.compare(that.age, this.age); // 내림차순
    }
}
