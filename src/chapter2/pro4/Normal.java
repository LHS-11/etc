package chapter2.pro4;

public class Normal implements DiscountMode{
    @Override
    public double getDiscountRate() {
        return 1.0;
    }
}
