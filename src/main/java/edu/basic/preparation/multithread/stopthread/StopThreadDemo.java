package edu.basic.preparation.multithread.stopthread;

/**
 * TODO : add description
 */
public class StopThreadDemo {

    public volatile boolean flag = true;
    int c = 0;

    public void first() {

        while (!Thread
                .currentThread()
                .isInterrupted()) {
            System.out.println("loop "+ c++);
        }

        System.out.println("still executing");
    }

    public void second() {

        while (flag == true) {
            System.out.println("second loop method "+ c++);
        }

        System.out.println("second still executing");
    }
}
