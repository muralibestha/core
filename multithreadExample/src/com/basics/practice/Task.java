package com.basics.practice;

import java.util.List;
import java.util.concurrent.Callable;

public class Task implements Callable<List<String>> {

    List<String> input;

    public Task(List<String> input) {
        this.input = input;
    }

    @Override
    public List<String> call() throws Exception {
        System.out.println("thread id:"+Thread.currentThread().getName()+" Started");
        return input;

    }
}
