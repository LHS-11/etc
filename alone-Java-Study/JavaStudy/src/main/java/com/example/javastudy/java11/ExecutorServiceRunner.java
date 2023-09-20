package com.example.javastudy.java11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {
    public static void main(String[] args) {

        // 한번에 하나의 쓰레드를 실행
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(실행하려는 Task);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.shutdown(); // 작동을 멈춤

    }
}
