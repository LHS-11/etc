package decoratorPattern.version1;

public abstract class Decorator extends Item{

    protected Item item; // Item 을 상속받은 모든 클래스에 대해서 장식 가능

    public Decorator(Item item) {
        this.item = item;
    }



}
