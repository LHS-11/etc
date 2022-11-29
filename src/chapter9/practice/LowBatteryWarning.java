package chapter9.practice;

public class LowBatteryWarning implements Observer{

    private static final int LOW_BATTERY = 30;
    private Battery battery;

    public LowBatteryWarning(Battery battery){
        this.battery = battery;
    }


    @Override
    public void update() {
        int level = battery.getLevel();
        display(level);
    }

    public void display(int level){
        if(level < LOW_BATTERY){
            System.out.println("<Warning> Low Battery: "+level+" Compared With "+LOW_BATTERY);
        }
    }
}
