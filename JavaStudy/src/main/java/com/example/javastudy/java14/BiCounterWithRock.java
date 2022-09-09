package com.example.javastudy.java14;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithRock {

    // locks => 동기화된 코드를 여러 조각의 코드로 쪼갤 수 있게 해줌

    private int i = 0;
    private int j = 0;

    Lock lockForI = new ReentrantLock();
    Lock lockForJ = new ReentrantLock();


     public void incrementI() { // 메서드마다 독립된 lock 를 가질 수 있음
        //Get Lock
        lockForI.lock();
        i++;
        lockForI.unlock();
        //Release Lock
    }

    synchronized public void incrementJ() {
        //Get Lock
        j++;
        //Release Lock

    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
