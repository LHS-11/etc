package chapter2;

import java.util.ArrayList;

public class ArrayStack {
    public int stackSize;
    private ArrayList<Integer> itemArray;

    public ArrayStack(int stackSize){
        itemArray = new ArrayList<>(stackSize);
        this.stackSize = stackSize;
    }

    public boolean isEmpty(){
        return itemArray.isEmpty();
    }

    public boolean isFull(){
        return (itemArray.size()-1==stackSize);
    }

    public void push(int item){
        if(isFull()){
            System.out.println("Inserting fail! Array Stack is full!!");
        }
        else{
            itemArray.add(new Integer(item));
            System.out.println("Inserted Item : "+item);
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Deleting fail! Array Stack is empty");
            return -1;
        }else{
            return itemArray.remove(itemArray.size() - 1);
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Peeking fail");
            return -1;
        }else{
            return itemArray.get(itemArray.size() - 1);
        }
    }
}
