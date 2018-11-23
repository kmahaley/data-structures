package edu.basic.preparation.multithread.producer.consumer;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        Processors processors = new Processors();

//       Producer-consumers using threads
        Thread t1 = new Thread(() -> processors.produce());
        Thread t2 = new Thread(() -> processors.consume());

        t1.start();
        t2.start();

        t1.join();
        t2.join();


//        Producer-consumers using executors
//        ExecutorService service = Executors.newFixedThreadPool(2);
//        service.submit(() -> processors.produce());
//        service.submit(() -> processors.consume());
//
//        service.shutdown();
    }
}
