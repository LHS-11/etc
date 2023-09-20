package chapter5.pro3;

public class Member {

    private String name;

    private int accPrice;

    public void addAccPrice(int price){
        this.accPrice += price;
    }

    public Member(String name){
        this.name = name;
        accPrice=0;
    }

    public String getName() {
        return name;
    }

    public int getAccPrice() {
        return accPrice;
    }
}
