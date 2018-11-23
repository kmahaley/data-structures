package edu.basic.preparation.multithread;

import edu.basic.preparation.multithread.runnable.CustomRunnable;
import edu.basic.preparation.multithread.thread.CustomThread;

public class MultiThreadApplication {


    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        CustomThread t1 = new CustomThread();
        CustomThread t2 = new CustomThread();
        t1.start();
        t2.start();

        Thread t3 = new Thread(new CustomRunnable());
        Thread t4 = new Thread(new CustomRunnable());
        t3.start();
        t4.start();

    }
}
