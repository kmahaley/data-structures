package edu.basic.preparation.multithread.latchandbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TODO : add description
 */
public class CyclicBarrierApplication {

    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(3);
        CyclicBarrierDemo barrierDemo = new CyclicBarrierDemo(barrier);

        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> barrierDemo.first());
        executorService.submit(() -> barrierDemo.second());
        executorService.submit(() -> barrierDemo.third());

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
