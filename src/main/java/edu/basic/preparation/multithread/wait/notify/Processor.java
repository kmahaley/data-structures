package edu.basic.preparation.multithread.wait.notify;

import java.util.Scanner;

import lombok.Data;

/**
 * wait and notify can be used only inside synchronised blocks
 */
@Data
public class Processor {

    volatile Object lock = new Object();

    public void producer() throws InterruptedException {

        synchronized (lock) {
            System.out.println("Inside producer");
            lock.wait();
            System.out.println("producer resumed");
        }
    }

    public void consumer() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (lock) {
            System.out.println("Press enter : ...");
            scanner.nextLine();
            System.out.println("Pressed entered");
            lock.notify();
            Thread.sleep(5000);
        }
    }
}
