package chapter2.pro4;

public class OnSale implements DiscountMode{
    @Override
    public double getDiscountRate() {
        return 0.9;
    }
}
