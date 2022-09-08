package com.example.javastudy.java11;


import java.util.concurrent.*;

class CallableTask implements Callable<String>{

    private String name;

    public CallableTask(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello "+name;
    }
}
public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<String> welcomeFuture // Future 결과가 나올 것이라고 예측
                = executorService.submit(new CallableTask("Paul"));// submit() 메서드를 통해 callable 실행 가능
        System.out.println("GGGGGGG");

        String welcomeMessage = welcomeFuture.get(); // task 가 실행을 완료할 때까지 기다림, task 가 실행을 끝낸 뒤에나 다음 코드가 실행됨

        System.out.println(welcomeMessage);

        System.out.println("Main completed");
    }
}
