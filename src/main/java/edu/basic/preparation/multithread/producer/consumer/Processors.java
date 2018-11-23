package edu.basic.preparation.multithread.producer.consumer;

import java.util.LinkedList;
import java.util.Random;

public class Processors {

    final int SIZE = 10;

    LinkedList<Integer> list = new LinkedList<>();

    private Object lock = new Object();

    public void produce() {
        Random random = new Random();
        try {
            while (true) {
                synchronized (lock) {

                    while (list.size() == SIZE) {
                        lock.wait();
                    }

                    final int anInt = random.nextInt(100);
                    System.out.println("Producer produced-" + anInt);
                    list.add(anInt);
                    lock.notify();
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void consume() {
        try {
            while (true) {
                synchronized (lock) {

                    while (list.size() == 0) {
                        lock.wait();
                    }

                    int val = list.removeFirst();
                    System.out.println("Consumer consumed-" + val);
                    lock.notify();
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
