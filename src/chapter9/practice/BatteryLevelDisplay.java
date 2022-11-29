package chapter9.practice;

public class BatteryLevelDisplay implements Observer{


    private Battery battery;

    public BatteryLevelDisplay(Battery battery){
        this.battery = battery;
    }

    @Override
    public void update() {
        int level = battery.getLevel();
        display(level);
    }

    public void display(int level){
        System.out.println("Level : "+level);
    }
}
