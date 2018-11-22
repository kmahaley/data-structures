package edu.basic.preparation.multithread.thread;

public class CustomThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                sleep(100);
                System.out.println(Thread.currentThread().getName() +" - "+i);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
