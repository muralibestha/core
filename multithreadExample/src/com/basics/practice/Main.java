package com.basics.practice;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<String> l1= Arrays.asList("a","b","c","d");
        List<String> l2= Arrays.asList("e","f","e","f");
        List<String> l3= Arrays.asList("g","h","i","j");
        List<String> l4= Arrays.asList("k","l","k","l");
        List<Set<String>> finalList = new ArrayList<>();
        List<Task> taskList = Arrays.asList(new Task(l1),new Task(l2),new Task(l3),new Task(l4));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            List<Future<List<String>>> futures = executorService.invokeAll(taskList);
            for (Future<List<String>> s:futures) {
                HashSet<String> strings = new HashSet<>(s.get());
                finalList.add(strings);
            }
            executorService.shutdown();
            System.out.println(finalList);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
