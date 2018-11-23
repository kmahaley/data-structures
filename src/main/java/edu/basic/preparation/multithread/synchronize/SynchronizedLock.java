package edu.basic.preparation.multithread.synchronize;

import lombok.Data;

/**
 * Locking mechanism using object lock
 */
@Data
public class SynchronizedLock {
    private int count;

    private Object lock = new Object();

    public void incrementCount() {

        synchronized (lock){
            count++;
        }
    }

    public void doWork() {

        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 3000; i++) {

                incrementCount();
            }
        }
    }
}
