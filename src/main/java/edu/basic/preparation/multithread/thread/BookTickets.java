package edu.basic.preparation.multithread.thread;/*
 * -----------------------------------------------------------------------------
 *  Copyright 2019 NCR Corporation
 * -----------------------------------------------------------------------------
 */

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO : add description
 */
@Data
@Slf4j
public class BookTickets {

    private int tickets;
    int a=0,b=0,c=0;
    AtomicInteger y = new AtomicInteger();
    volatile int x;
    boolean flag = true;

    Lock lock = new ReentrantLock();

    public BookTickets(int tickets) {
        this.tickets = tickets;
    }

    public void bookMyTickets() {
            lock.lock();
        if (tickets > 0) {
            System.out.println(tickets);
            tickets--;
        }
            lock.unlock();
    }

    public void write() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
    }

    public void read() {
        int c =0;
        while (flag) {
            System.out.println(++c);

        }
    }

    public void update1() {
        while(flag) {
            y.incrementAndGet();
            System.out.println("--- "+y.get());
        }
    }

    public void update2() {
        while(flag) {
            y.incrementAndGet();
            System.out.println("*** "+y.get());
        }
    }
}
