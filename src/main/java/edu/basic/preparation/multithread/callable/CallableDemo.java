package edu.basic.preparation.multithread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo {

    public void doWork(int numbers) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 1 ; i < numbers; i++) {
            futures.add(executorService.submit(new CallableFactorial(i)));
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        Long sum = 0L;

        for (Future<Integer> future :futures) {
            final Integer fact = future.get();
            System.out.println(fact);
            sum = sum + fact;
        }

        System.out.println(sum);

    }
}
