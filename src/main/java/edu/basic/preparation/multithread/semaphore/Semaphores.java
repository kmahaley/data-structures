package edu.basic.preparation.multithread.semaphore;


import java.util.concurrent.Semaphore;

public class Semaphores implements Runnable {

    public static Semaphore semaphore = new Semaphore(3);

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+ " : Available permits : "+semaphore.availablePermits());
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" : Acquired permit : "+semaphore.availablePermits());

            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
            }

        } catch (InterruptedException ex) {
            System.out.println(" interrupted thread ");
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName()+" :Released, Available permits : "+semaphore.availablePermits());
        }

    }
}
