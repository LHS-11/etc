package decoratorPattern.version2;

public abstract class Decorator extends Coffee{
    // 이러한 데코레이터는 실제 오브젝트 일수도 있고, 또 다른 데코레이터일수도 있다.
    // Decorator 클래스의 경우 상속 목적으로만 쓸 것이기 때문에 추상 클래스로 만듦
    public Coffee coffee;

    public Decorator(Coffee coffee){
        this.coffee = coffee;
    }

}
