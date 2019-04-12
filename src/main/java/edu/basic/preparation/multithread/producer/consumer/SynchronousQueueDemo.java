package edu.basic.preparation.multithread.producer.consumer;

import java.util.concurrent.SynchronousQueue;

/**
 * Synchronous queue implementation hand off between two threads
 */
public class SynchronousQueueDemo {

    SynchronousQueue<Integer> queue = new SynchronousQueue<>();

    int c = 0;

    public void produce() {

        while (true) {
            try {
                Thread.sleep(1000);
                int x = ++c;
                System.out.println(x);
                queue.put(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void consume() {

        while (true) {

            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
