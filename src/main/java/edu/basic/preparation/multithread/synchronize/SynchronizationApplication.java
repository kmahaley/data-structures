package edu.basic.preparation.multithread.synchronize;

public class SynchronizationApplication {

    public static void main(String[] args) {

//        Method synchronization
        Synchronization synchronization = new Synchronization();
        synchronization.doWork();
        System.out.println(synchronization.getCount());

//        synchronized block
        SynchronizedLock synchronizedLock = new SynchronizedLock();
        synchronizedLock.doWork();
        System.out.println(synchronizedLock.getCount());
    }
}
