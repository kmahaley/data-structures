package edu.basic.preparation.multithread.synchronize;

import lombok.Data;

@Data
public class Synchronization {

    private int count;

    public synchronized void incrementCount() {
        count++;
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
            for (int i = 0; i < 2000; i++) {

                incrementCount();
            }
        }
    }
}
