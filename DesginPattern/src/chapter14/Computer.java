package chapter14;

public class Computer {

    private Keyboard keyboard;
    private Mouse mouse;

    public void addKeyboard(Keyboard keyboard){
        this.keyboard = keyboard;
    }

    public void addMouse(Mouse mouse){
        this.mouse = mouse;
    }

    public int getPrice(){
        int keyboardPrice = keyboard.getPrice();
        int mousePrice = mouse.getPrice();
        return keyboardPrice + mousePrice;
    }

    public int getPower(){
        int keyboardPower = keyboard.getPower();
        int mousePower = mouse.getPower();
        return keyboardPower + mousePower;
    }
}
