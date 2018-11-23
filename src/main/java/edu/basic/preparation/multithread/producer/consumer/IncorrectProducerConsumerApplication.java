package edu.basic.preparation.multithread.producer.consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Incorrect way to implement producer and consumer
 * queue can be full or empty
 */
public class IncorrectProducerConsumerApplication {

    public static BlockingQueue<Integer> queue = new ArrayBlockingQueue(20);

    public static void producer() {
        Random random = new Random();

        while (true) {
            queue.add(random.nextInt(100));
        }
    }

    public static void consumer() {
        Random random = new Random();

        while (true) {
            if (random.nextInt() % 2 == 0) {

                Integer take = -1;
                try {
                    take = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("No taken = " + take + " - Size of queue = " + queue.size());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> producer());
        Thread t2 = new Thread(() -> consumer());

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }


}
