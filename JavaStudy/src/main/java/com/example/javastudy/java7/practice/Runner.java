package com.example.javastudy.java7.practice;

public class Runner {
    public static void main(String[] args) {
        Flyable[] flyingObjects = {new Bird(), new Airplane()};

        for (Flyable flyingObject : flyingObjects) {
            flyingObject.fly();
        }

        Animal[] animals = {new Dog(), new Cat()};

        for (Animal animal : animals) {
            animal.bark();
        }
    }

}