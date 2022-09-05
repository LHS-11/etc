package com.example.javastudy.java7.inheritance;

public class Person {
    private String name;
    private int phone;

    private String email;

    public Person(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }


    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {

        return  "name=' " + name + '\'' +
                ", phone= " + phone +
                ", email=' " + email + '\'' ;
    }
}
