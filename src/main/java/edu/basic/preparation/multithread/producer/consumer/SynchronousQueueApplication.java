package edu.basic.preparation.multithread.producer.consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TODO : add description
 */
public class SynchronousQueueApplication {

    public static void main(String[] args) {

        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        SynchronousQueueDemo synchronousQueueDemo = new SynchronousQueueDemo();
        executorService.submit(() -> synchronousQueueDemo.produce());
        executorService.submit(() -> synchronousQueueDemo.consume());
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
