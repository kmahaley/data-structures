package edu.basic.preparation.multithread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demo of executor service
 */
public class ExecutorServiceDemo {

    public void produceFactorials(){

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 1; i < 30 ; i++) {
            executorService.execute(new ProduceFactorial(i));
        }
        System.out.println("Submitted all tasks");

        executorService.shutdown();

        System.out.println("Shut down");
        boolean awaitTermination = false;
        try {
            awaitTermination = executorService.awaitTermination(2, TimeUnit.SECONDS);
            executorService.shutdownNow();


        } catch (InterruptedException e) {
            System.out.println("Terminated ");
        }
    }


    class ProduceFactorial implements Runnable {

        long no;

        public ProduceFactorial(long n) {
           this.no = n;
        }

        @Override
        public void run() {


            try {
                long fact = 1;
                for (int i = 1; i <= no ; i++) {
                    fact = fact * i;
                }
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+ " - " +no +" - "+fact);
            } catch (InterruptedException e) {
                System.out.println("Time up -------");
            }
        }
    }
}
