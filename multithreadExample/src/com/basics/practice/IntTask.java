package com.basics.practice;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntTask  implements Callable<List<Integer>> {

    Integer i;

    public IntTask(Integer i) {
        this.i = i;
    }

    @Override
    public List<Integer> call() throws Exception {
        System.out.println(Thread.currentThread().getId() +" Thread started for " +i +" task @" + Instant.now());
       List<Integer> intList=Stream.iterate(i, x -> x * i).limit(10000).collect(Collectors.toList());
       System.out.println(Thread.currentThread().getId() +" Thread Completed for " +i +" task @" + Instant.now());
       return intList;
    }
}
