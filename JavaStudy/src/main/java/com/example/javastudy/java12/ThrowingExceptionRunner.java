package com.example.javastudy.java12;


class Amount{
    private String currency;
    private int amount;

    public Amount(String currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public void add(Amount other) throws CurrenciesDoNotMatchException {

        if(!this.currency.equals(other.currency)) {
//            throw new Exception("Currencies Don't Match "+this.currency+" "+other.currency);
            throw new CurrenciesDoNotMatchException("Currencies Don't Match "+this.currency+" "+other.currency);
        }
        this.amount += other.amount;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
class CurrenciesDoNotMatchException extends Exception{
    public CurrenciesDoNotMatchException(String msg){
        super(msg); // Exception 에 생성자로 msg 를 남기는 것이 있음
    }
}
public class ThrowingExceptionRunner {

    public static void main(String[] args) throws CurrenciesDoNotMatchException {

        Amount amount1 = new Amount("USD", 10);
        Amount amount2 = new Amount("EUR", 20);

        amount1.add(amount2);
        System.out.println(amount1);
    }
}
