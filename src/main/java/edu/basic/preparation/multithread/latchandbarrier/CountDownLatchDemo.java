package edu.basic.preparation.multithread.latchandbarrier;

import java.util.concurrent.CountDownLatch;

/**
 * TODO : add description
 */
public class CountDownLatchDemo {

    CountDownLatch latch;

    public CountDownLatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    public void first() {
        try {
            System.out.println("first count down begin");
            Thread.sleep(2000);
            System.out.println("first count down end");
            latch.countDown();
            System.out.println("count down 1 done");
        } catch (InterruptedException ex ) {

        }
    }

    public void second() {
        try {
            System.out.println("second count down begin");
            Thread.sleep(100);
            System.out.println("second count down end");
            latch.countDown();
            System.out.println("count down 2 done");
        } catch (InterruptedException ex ) {

        }
    }

    public void third() {
        try {
            System.out.println("waiting");
            latch.await();
            System.out.println("third executed");
        } catch (InterruptedException ex ) {

        }
    }
}
