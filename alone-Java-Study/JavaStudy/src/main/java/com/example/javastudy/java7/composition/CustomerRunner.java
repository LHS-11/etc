package com.example.javastudy.java7.composition;

public class CustomerRunner {

    public static void main(String[] args) {
        Address address = new Address("a", "b", "c");
        Customer customer = new Customer("Paul", address);
        Address workAddress = new Address("d", "e", "f");
        customer.setWorkAddress(workAddress);

        System.out.println("customer = " + customer);

    }
}
