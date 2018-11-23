package edu.basic.preparation.multithread.producer.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Producer consumer using thread safe class. ArrayBlockingQueue
 * hence no need of wait, notify and synchronized
 */
public class ProcessorsBlockingQueue {

    final int CAPACITY = 11;

    final int EMPTY = 0;
    /**
     * Thread safe class
     */
    BlockingQueue<Integer> list = new ArrayBlockingQueue<>(CAPACITY);

    public void produce() {
        try {
            int value = 1;
            while (true) {

                if (list.size() < CAPACITY) {
                    System.out.println("Producer produced-" + value);
                    list.add(value++);
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void consume() {
        try {
            while (true) {
                if (list.size() > EMPTY) {

                    int val = list.take();
                    System.out.println("Consumer consumed-" + val + "  Size of queue : " + list.size());
                }
                Thread.sleep(4000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
