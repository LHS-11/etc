package com.example.javastudy.java7.inheritance;

public class StudentRunner {

    public static void main(String[] args) {

        Employee employee = new Employee("paul","사장님");
        employee.setEmail("dasd");
        employee.setEmployer("James");
//        System.out.println(employee);

        Person person = new Person("ss");


        System.out.println(employee instanceof Person);
        System.out.println(person instanceof Employee);
    }
}
