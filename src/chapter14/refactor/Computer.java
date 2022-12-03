package chapter14.refactor;

import java.util.List;

public class Computer {

    private List<ComputerDevice> computerDeviceList;

    public void addComputerDevice(ComputerDevice computerDevice){
        computerDeviceList.add(computerDevice);
    }

    public int getPrice(){
        int price=0;
        for (ComputerDevice computerDevice : computerDeviceList) {
            price += computerDevice.getPrice();
        }
        return price;
    }

    public int getPower(){
        int power=0;
        for(ComputerDevice computerDevice: computerDeviceList){
            power += computerDevice.getPower();
        }
        return power;
    }
}
