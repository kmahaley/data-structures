package edu.basic.preparation.multithread.wait.notify;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        Processor processor = new Processor();

        Thread t1 = new Thread(() -> {
            try {
                processor.producer();
            } catch (InterruptedException e) {
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                processor.consumer();
            } catch (InterruptedException e) {
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
