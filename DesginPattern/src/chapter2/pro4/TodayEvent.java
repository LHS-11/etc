package chapter2.pro4;

public class TodayEvent implements DiscountMode{
    @Override
    public double getDiscountRate() {
        return 0.7;
    }
}
