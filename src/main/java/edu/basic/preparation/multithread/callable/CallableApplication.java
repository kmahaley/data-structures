package edu.basic.preparation.multithread.callable;

import java.util.concurrent.ExecutionException;

public class CallableApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CallableDemo callableDemo = new CallableDemo();
        callableDemo.doWork(10);
    }
}
