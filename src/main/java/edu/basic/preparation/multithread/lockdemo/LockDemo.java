package edu.basic.preparation.multithread.lockdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO : add description
 */
public class LockDemo {

    Lock lock = new ReentrantLock();

    int count = 100;

    public LockDemo() {
    }

    public void getSeats() {
        lock.lock();
        count--;

        System.out.println(Thread
                .currentThread()
                .getName()+" - "+count);
        lock.unlock();

    }
}
