package com.example.javastudy.java9;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MyCustomList<T extends Number> {

    ArrayList<T> list = new ArrayList<>();

    Vector<T> vector = new Vector<>();

    List<T>[] list1=new List[2];

    public void addElement(T element){

        list.add(element);
    }

    public void removeElement(T element){
        list.remove(element);
    }

    public T get(int index){
        return list.get(index);
    }
}
