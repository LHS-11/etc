package chapter14.refactor;

import java.util.List;

public class Computer extends ComputerDevice{

    private List<ComputerDevice> computerDevices;

    public void addComputerDevices(ComputerDevice computerDevice){
        computerDevices.add(computerDevice);
    }

    public void removeComputerDevices(ComputerDevice computerDevice){
        computerDevices.remove(computerDevice);
    }

    public int getPrice(){
        int sum=0;
        for (ComputerDevice computerDevice : computerDevices) {
            sum += computerDevice.getPrice();
        }
        return sum;
    }

    public int getPower(){
        int sum=0;
        for (ComputerDevice computerDevice : computerDevices) {
            sum += computerDevice.getPower();
        }
        return sum;
    }
}
