package chapter2.check1;

import java.util.Vector;

public class MyStack<String>{

    private Vector<String> myStack = new Vector<>();


    public void push(String e){
        myStack.add(e);
    }

    public void pop(){
        myStack.remove(myStack.size() - 1);
    }

    public boolean isEmpty(){
        return myStack.isEmpty();
    }

    public int size(){
        return myStack.size();
    }
}
