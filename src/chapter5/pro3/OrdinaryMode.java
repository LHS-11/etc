package chapter5.pro3;

public class OrdinaryMode implements DiscountMode{
    @Override
    public int calcPrice(int price, int n) {
        return price * n;
    }
}
