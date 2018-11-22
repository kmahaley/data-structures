package edu.basic.preparation.multithread.runnable;

import static java.lang.Thread.sleep;

public class CustomRunnable implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                sleep(100);
                System.out.println(Thread.currentThread().getName()+" - "+i);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
