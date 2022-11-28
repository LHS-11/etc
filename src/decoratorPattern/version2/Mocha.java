package decoratorPattern.version2;

public class Mocha extends Decorator {

    public Mocha(Coffee coffee){
        super(coffee);
    }


    @Override
    public void brewing() {
        coffee.brewing();
        System.out.println("Adding Mocha Syrup");
    }
}
