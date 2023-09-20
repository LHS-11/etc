package chapter2.pro4;

public class Song {

    private DiscountMode mode;

    public void setMode(DiscountMode mode){
        this.mode = mode;
    }
    public DiscountMode getMode(){
        return this.mode;
    }

    public double getPrice() {
        return 10.0;
    }
}
