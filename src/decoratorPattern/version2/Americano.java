package decoratorPattern.version2;

public class Americano extends Coffee{

    @Override
    public void brewing() {
        System.out.println("Americano coffee");
    }
}
