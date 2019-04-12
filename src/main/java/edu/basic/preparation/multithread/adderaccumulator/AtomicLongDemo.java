package edu.basic.preparation.multithread.adderaccumulator;

import java.util.concurrent.atomic.LongAdder;

/**
 * TODO : add description
 */
public class AtomicLongDemo implements Runnable {

    LongAdder aLong;

    public AtomicLongDemo(LongAdder aLong) {
        this.aLong = aLong;
    }

    @Override
    public void run() {
        aLong.increment();
    }
}
