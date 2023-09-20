package com.example.javastudy.java11;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<CallableTask> tasks = List.of(new CallableTask("paul"), new CallableTask("james"), new CallableTask("brook"));

        System.out.println("시부루루루루루루");

        List<Future<String>> results = executorService.invokeAll(tasks);

        for (Future<String> result : results) {
            System.out.println("result = " + result.get());

        }



        executorService.shutdown(); // 모든 쓰레드의 실행이 완료된 후에 executorService 종료
    }
}
