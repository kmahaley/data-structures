package edu.basic.preparation.multithread.semaphore;


import java.util.concurrent.Semaphore;

public class SemaphoresDemo implements Runnable {

    public static Semaphore semaphore = new Semaphore(3);

    public static Semaphore sem1 = new Semaphore(1);
    public static Semaphore sem2 = new Semaphore(1);

    public SemaphoresDemo() {
        try {
            sem1.acquire();
            sem2.acquire();
        } catch (Exception ex) {}
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+ " : Available permits : "+semaphore.availablePermits());

            semaphore.acquire();
            //Perform logic
            System.out.println(Thread.currentThread().getName()+" : Acquired permit : "+semaphore.availablePermits());
            Thread.sleep(2000);

        } catch (InterruptedException ex) {
            System.out.println(" interrupted thread ");
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName()+" :Released, Available permits : "+semaphore.availablePermits());
        }

    }

    public void runWithAcquire() {
        try{
            System.out.println(Thread.currentThread().getName()+ " : Available permits : "+semaphore.availablePermits());
            semaphore.acquire();
            Thread.sleep(3000);
            semaphore.release();
            System.out.println(Thread.currentThread().getName()+ " : Available permits : "+semaphore.availablePermits());
        } catch (InterruptedException ex) { }

    }

    public void runWithTryAcquire() {
        try {
            System.out.println(Thread.currentThread().getName()+ " : Available permits : "+semaphore.availablePermits());

            if(semaphore.tryAcquire()) {
                System.out.println(Thread.currentThread().getName() + " try acquired : acquired");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+ " : releasing semaphore");
                semaphore.release();
            } else {
                System.out.println("try acquired : failed");
            }
        } catch (InterruptedException ex) { }

    }

    public void runWithMultipleAcquire() {

        try {
            System.out.println(Thread.currentThread().getName()+ " : Available permits : "+semaphore.availablePermits());
            semaphore.acquire(3);
            System.out.println("logic on runWithMultipleAcquire");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+ " : releasing 3 semaphore");
            semaphore.release(3);
        } catch (InterruptedException ex) { }

    }

    public void first() {

        System.out.println("------------- first");
        sem1.release();

    }

    public void second() {

        try {
            sem1.acquire();
            System.out.println("------------- second");
            sem1.release();
            sem2.release();
        } catch (Exception ex) {}

    }

    public void third() {
        try {
            sem2.acquire();
            System.out.println("------------- third");
            sem2.release();
        } catch (Exception ex) {}

    }
}
