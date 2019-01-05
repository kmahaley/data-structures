package edu.basic.preparation.multithread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoresApplication {

    public static void main(String[] args) {

        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        final Semaphores semaphores = new Semaphores();
        for (int i = 0; i < 4 ; i++) {

            executorService.submit(semaphores);
        }
        executorService.shutdown();
    }
}
