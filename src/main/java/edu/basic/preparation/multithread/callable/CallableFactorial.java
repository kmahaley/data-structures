package edu.basic.preparation.multithread.callable;

import java.util.concurrent.Callable;

public class CallableFactorial implements Callable<Integer> {

    private int no;

    public CallableFactorial(int no) {
        this.no = no;
    }

    @Override
    public Integer call() throws Exception {

        int fact = 1;
        for (int i = 1; i <= no ; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
