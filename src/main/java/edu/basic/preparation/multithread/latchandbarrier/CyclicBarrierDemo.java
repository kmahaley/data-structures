package edu.basic.preparation.multithread.latchandbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * TODO : add description
 */
public class CyclicBarrierDemo {

    CyclicBarrier barrier;

    public CyclicBarrierDemo(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void first() {
        try {
            System.out.println("first barrier begin");
            Thread.sleep(2000);
            barrier.await();
            System.out.println("first barrier processing resume");
        } catch (BrokenBarrierException | InterruptedException ex ) {

        }
    }

    public void second() {
        try {
            System.out.println("second barrier begin");
            Thread.sleep(2000);
            barrier.await();
            System.out.println("second barrier processing resume");
        } catch (BrokenBarrierException | InterruptedException ex ) {
        }
    }

    public void third() {
        try {
            System.out.println("third barrier begin");
            Thread.sleep(2000);
            barrier.await();
            System.out.println("third barrier processing resume");
        } catch (BrokenBarrierException | InterruptedException ex ) {
        }
    }
}
