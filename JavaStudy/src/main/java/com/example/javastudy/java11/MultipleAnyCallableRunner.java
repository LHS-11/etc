package com.example.javastudy.java11;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleAnyCallableRunner {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableTask> tasks = List.of(new CallableTask("paul"), new CallableTask("james"), new CallableTask("brook"));

        System.out.println("시부루루루루루루");

        String result = executorService.invokeAny(tasks); // 소비자에게 가장 빠른 결과를 제공하고 싶을 때
        // invokeAny task 중 하나의 실행이 완료시 가장 먼저 나오는 결과를 반환

        System.out.println("result = " + result);



        executorService.shutdown(); // 모든 쓰레드의 실행이 완료된 후에 executorService 종료
    }
}
