package com.example.javastudy.java2;

import java.math.BigDecimal;

public class SimpleInterestCalculator {

//    private String principal;
//    private String interest;

    private BigDecimal principal;

    private BigDecimal interest;


    /*public SimpleInterestCalculator(String principal, String interest) {
        this.principal = principal;
        this.interest = interest;
    }*/

    public SimpleInterestCalculator(String principal, String interest) {
        this.principal =new BigDecimal(principal);
        this.interest = new BigDecimal(interest);
    }

    public BigDecimal calculateTotalValue(int year){
        return this.principal.add((this.principal.multiply(this.interest.divide(new BigDecimal(100)))).multiply(new BigDecimal(year)));
    }
}
