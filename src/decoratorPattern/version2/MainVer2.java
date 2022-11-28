package decoratorPattern.version2;

public class MainVer2 {
    public static void main(String[] args) {
        Coffee coffee = new Americano();
        coffee.brewing();

        Coffee mocha = new Latte(new Mocha(coffee));
        mocha.brewing();
    }
}
