Thread 는 유사성을 가진 모든 수행문을 동시에 실행하게 해줌
=> 자원 낭비를 줄여줌 (CPU 효율성 향상)
=> 병렬적으로 함께 실행 가능

1. Thread 확장 (Thread 상속)
ex) class Task1 extends Thread{
    public void run(){

    }
}
=> Task1 task1=new Task1();
task1.start();


2. Runnable 인터페이스 실행
ex) class Task1 implements Runnable{
        public void run(){

        }
}
=> Task2 task2=new Task2();
Thread task2Thread= new Thread(task2);

Thread 상태
- NEW : Thread 가 처음 생성될 때의 상태
- RUNNABLE : 일 혹은 작업을 처리하고 싶기는 하지만, 다른 Thread 가 우선적으로 실행되고 있는 상태
- RUNNING : Thread 가 실행 중인 상태
- BLOCKED/WAITING :
외부 인터페이스나 데이터베이스 등으로부터 어떤 입력을 위해 대기하고 있거나, 실행이 완료되지 않은 다른 Thread 로부터 데이터를 입력받아야 하는 상황
- TERMINATED/DEAD : 실행이 완료되었을 경우 의미

Thread 우선순위
setPriority (1~10)
=> 추천일 뿐 강제가 아님

Threads 사이의 소통
join 메서드 => 특정 Thread 의 실행이 끝날 때까지 대기한다는 의미 ( task 가 완료된 후에나 다음 줄의 코드 실행 )

Thread.sleep(1000) => 1초 동안 대기

Thread.yield() => CPU 를 포기하도록 요청

synchronized ( 동기화 ) => 하나의 쓰레드에 동기화된 코드의 작업 가능 so 오버헤드

Executor Service ( 실행기 ) => 다수의 쓰레드를 한 번에 실행할 수 있도록 도와줌, 쓰레드의 상태를 알게 해줌

newSingleThreadExecutor (한 개의 쓰레드) <-> newFixedThreadPool (여러 개의 쓰레드)

Thread 에서 결과를 얻는 지점 또한 설정 가능

Callable => Callable 인터페이스를 이용해서 후처리 스레드로 돌아오기

Future (결과가 나올 것이라고 예측)
ex) Future<String> welcomeFuture
                   = executorService.submit(new CallableTask("Paul"));
                   submit() 메서드를 통해 callable 실행 가능
    String welcomeMessage = welcomeFuture.get(); => task 가 실행될 때까지 기다림, task 가 실행을 끝낸 뒤에나 이 다음 코드 실행
    get() 메서드를 쓰는 시점 이후부터 후처리

invokeAll : 모든 작업이 완료된 후에 한번에 다 출력 (모든 task 의 처리가 끝날 때까지 기다림)
<-> invokeAny : 하나의 작업이 먼저 끝나면 먼저 결과를 출력 (한개의 task 가 실행이 완료되는 것을 기다린 후, 결과를 얻음)


