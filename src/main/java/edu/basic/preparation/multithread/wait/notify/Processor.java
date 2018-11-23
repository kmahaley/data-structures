package edu.basic.preparation.multithread.wait.notify;

import java.util.Scanner;

import lombok.Data;

@Data
public class Processor {

    public void producer() throws InterruptedException {
        synchronized (this) {
            System.out.println("Inside producer");
            wait();
            System.out.println("resumed");
        }
    }

    public void consumer() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("Press enter : ...");
            scanner.nextLine();
            System.out.println("Pressed entered");
            notify();
            Thread.sleep(5000);
        }
    }
}
