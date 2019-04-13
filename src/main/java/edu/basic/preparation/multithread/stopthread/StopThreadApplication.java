package edu.basic.preparation.multithread.stopthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TODO : add description
 */
public class StopThreadApplication {

    public static void main(String[] args) {

        StopThreadDemo stopThreadDemo = new StopThreadDemo();

        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> stopThreadDemo.first());
        executorService.shutdown();

        Thread t1 = new Thread(() -> stopThreadDemo.first());
        t1.start();

        Thread t2 = new Thread(() -> stopThreadDemo.second());
        t2.start();


        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("now...................................");
            executorService.shutdownNow();
            t1.interrupt();
            stopThreadDemo.flag = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
