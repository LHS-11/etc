package chapter9.practice;

public class Client {

    public static void main(String[] args) {

        Battery battery = new Battery();

        BatteryLevelDisplay batteryLevelDisplay = new BatteryLevelDisplay(battery);
        battery.attach(batteryLevelDisplay);

        LowBatteryWarning lowBatteryWarning = new LowBatteryWarning(battery);
        battery.attach(lowBatteryWarning);

        battery.consume(80);
        battery.consume(30);
        battery.consume(40);

    }
}
