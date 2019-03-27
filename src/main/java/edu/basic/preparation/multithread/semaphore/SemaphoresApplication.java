package edu.basic.preparation.multithread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoresApplication {

    public static void main(String[] args) {

        final ExecutorService executorService = Executors.newFixedThreadPool(4);

        final SemaphoresDemo semaphoresDemo = new SemaphoresDemo();

        final MultiThreadFunctions functions = new MultiThreadFunctions();

//        for (int i = 0; i < 3 ; i++) {
//            executorService.submit(() -> functions.factorial());
//            executorService.submit(() -> functions.reverseNumber());
//        }

//        executorService.submit(() -> semaphoresDemo.runWithTryAcquire());
//        executorService.submit(() -> semaphoresDemo.runWithMultipleAcquire());

        executorService.submit(() -> semaphoresDemo.first());
        executorService.submit(() -> semaphoresDemo.second());
        executorService.submit(() -> semaphoresDemo.third());

        executorService.shutdown();
    }
}
