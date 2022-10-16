package chapter1.check6;

public class Person {

    private String name;

    private Car owns;

    public void setCar(Car car){
        this.owns = car;
    }


    public String getName(){
        return this.name;
    }
}
