package com.example.javastudy.java7.composition;

public class Address {
    private String lin1;
    private String city;
    private String zip;

    public Address(String lin1, String city, String zip) {
        this.lin1 = lin1;
        this.city = city;
        this.zip = zip;
    }

    public String toString(){
        return String.format("[%s, %s, %s]", lin1, city, zip);
    }
}
