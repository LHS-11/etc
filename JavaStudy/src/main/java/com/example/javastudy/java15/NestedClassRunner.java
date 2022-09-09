package com.example.javastudy.java15;

class DefaultClass{

}
public class NestedClassRunner {

    class InnerClass{

    }

    static class StaticNestedClass{

    }

    public static void main(String[] args) {

//        InnerClass innerClass = new InnerClass(); // NestedClassRunner 의 인스턴스가 필요

        StaticNestedClass staticNestedClass = new StaticNestedClass();

        NestedClassRunner nestedClassRunner = new NestedClassRunner();

        InnerClass innerClass = nestedClassRunner.new InnerClass();

    }
}
