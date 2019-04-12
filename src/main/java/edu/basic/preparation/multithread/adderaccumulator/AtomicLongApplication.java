package edu.basic.preparation.multithread.adderaccumulator;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * TODO : add description
 */
public class AtomicLongApplication {

    public static void main(String[] args) {

        LongAdder atomicLong = new LongAdder();

        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 50; i++) {
            executorService.submit(new AtomicLongDemo(atomicLong));
        }

        try {
            executorService.shutdown();
            executorService.awaitTermination(3000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicLong.sum());
    }
}
