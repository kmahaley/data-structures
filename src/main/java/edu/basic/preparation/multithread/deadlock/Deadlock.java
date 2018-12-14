package edu.basic.preparation.multithread.deadlock;

/**
 * Display deadlock
 */
public class Deadlock {

    Object lock1 = new Object();

    Object lock2 = new Object();


    public void method1() {

        try {
            synchronized (lock1) {
                System.out.println("lock1 received");

                Thread.sleep(1000);

                synchronized (lock2) {
                    System.out.println("lock2 received");
                }
            }

        } catch (InterruptedException ex) {
            System.out.println("method1 interrupted");
        }

    }

    public void method2() {

        try {
            synchronized (lock2) {
                System.out.println("lock2 received");

                Thread.sleep(1000);

                synchronized (lock1) {
                    System.out.println("lock1 received");
                }
            }

        } catch (InterruptedException ex) {
            System.out.println("method2 interrupted");
        }

    }
}
