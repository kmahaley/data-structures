package edu.basic.preparation.multithread.latchandbarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TODO : add description
 */
public class LatchApplication {


    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(2);
        CountDownLatchDemo latchDemo = new CountDownLatchDemo(latch);

        final ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> latchDemo.third());
        executorService.submit(() -> latchDemo.first());
        executorService.submit(() -> latchDemo.second());

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Terminated application");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
