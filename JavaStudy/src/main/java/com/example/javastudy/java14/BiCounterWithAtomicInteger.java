package com.example.javastudy.java14;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithAtomicInteger {

    // locks => 동기화된 코드를 여러 조각의 코드로 쪼갤 수 있게 해줌

    private AtomicInteger i = new AtomicInteger();
    private AtomicInteger j = new AtomicInteger();

    Lock lockForI = new ReentrantLock();
    Lock lockForJ = new ReentrantLock();


     public void incrementI() { // 메서드마다 독립된 lock 를 가질 수 있음
        i.incrementAndGet(); // AtomicInteger 에 의존하여 thread-safe 한지를 확인하게 됨 ( locks 에 의무를 가져와서 AtomicInteger 에 부여)
        // 다양한 연산의 과정들이 필요할 경우 AtomicInteger 보단 lock 사용
    }

     public void incrementJ() {
         j.incrementAndGet();

    }

    public int getI() {
        return i.get();
    }

    public int getJ() {
        return j.get();
    }
}
