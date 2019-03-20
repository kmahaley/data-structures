package edu.basic.preparation.multithread.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class BookMain {

    public static void main(String[] args) throws InterruptedException {

        LongAdder longAdder = new LongAdder();
        System.out.println(longAdder.longValue());
        List<Future<List<Integer>>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5 ; i++) {
            final Book book = new Book(i);
            final Future<List<Integer>> submit = executorService.submit(() -> book.lists());
            futures.add(submit);
        }


        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);
        StringBuilder builder = new StringBuilder();

        futures.forEach(f -> {
            try {
                 builder.append(f.get().stream().mapToInt(x-> x.intValue()).sum());
                 builder.append(" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println(builder.toString());
    }
}
