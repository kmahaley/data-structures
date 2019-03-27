package edu.basic.preparation.multithread.semaphore;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Multiple threads with function
 */
public class MultiThreadFunctions {

    private int fact;

    private Lock lock;

    private volatile int unstable = 1;

    private int unstableNo = 123;

    public MultiThreadFunctions() {
        fact = 5;
        lock = new ReentrantLock();
    }

    public void factorial() {

        lock.lock();
        int result = 1;
        for (int i = 1; i < fact; i++) {
            unstable = unstable * i;
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }
        }
        System.out.println(Thread.currentThread().getName() + " ----- " + unstable);
        lock.unlock();
    }


    public void reverseNumber() {

        lock.lock();
        int no = unstableNo, result = 0;
        while (no > 0) {
            int rem = no % 10;
            result = result * 10 + rem;
            no = no / 10;
        }
        System.out.println(Thread.currentThread().getName() + " ----- " + result);
        unstableNo = result;
        lock.unlock();
    }

}
