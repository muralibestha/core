package com.basics.practice;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class intMain {
    public static void main(String[] args) throws InterruptedException {
        List<IntTask> tasks = new ArrayList<>();
        for (int i = 2; i <=5 ; i++) {
            tasks.add(new IntTask(i));
        }
        Instant start = Instant.now();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<List<Integer>>> futures = executorService.invokeAll(tasks, 5, TimeUnit.SECONDS);

        executorService.shutdown();
        System.out.println("Time for execution: "+ Duration.between(start,Instant.now()).toMillis());
    }
}
