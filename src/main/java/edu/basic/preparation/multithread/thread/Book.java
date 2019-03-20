package edu.basic.preparation.multithread.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Book implements Callable<Long> {

    int i;

    public Book(int i) {
        this.i = i;
    }

    public List<Integer> lists() {
        final List<Integer> integers = Arrays.asList(1, 2);
        return integers.stream().map(x -> x*i).collect(Collectors.toList());
    }

    @Override
    public Long call() throws Exception {

        return 0l;
    }
}
