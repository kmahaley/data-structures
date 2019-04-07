package edu.basic.preparation.multithread.thread;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2019 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO : add description
 */
public class BookTicketsApplication {

    public static void main(String[] args) throws InterruptedException {

        BookTickets bookTickets = new BookTickets(100);
        final ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> bookTickets.update1());
        executorService.execute(() -> bookTickets.update2());
        executorService.execute(() -> bookTickets.write());

        executorService.shutdown();
        Thread.sleep(2000);
        System.out.println("------------------------- "+ bookTickets.getY());
    }
}
