package edu.basic.preparation.multithread.deadlock;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockApplication {

    public static void main(String[] args) throws InterruptedException {

        Deadlock deadlock = new Deadlock();

//        Thread t1 = new Thread(() -> deadlock.method1());
//        Thread t2 = new Thread(() -> deadlock.method2());
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> deadlock.method1());
        executorService.submit(() -> deadlock.method2());

        executorService.shutdown();
    }
}
