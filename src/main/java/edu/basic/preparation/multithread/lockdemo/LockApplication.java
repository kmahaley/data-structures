package edu.basic.preparation.multithread.lockdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TODO : add description
 */
public class LockApplication {

    public static void main(String[] args) {

        LockDemo lockDemo = new LockDemo();

        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 50; i++) {

            executorService.submit(() -> lockDemo.getSeats());
        }


        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
