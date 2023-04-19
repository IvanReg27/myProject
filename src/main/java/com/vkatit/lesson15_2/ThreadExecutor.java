package com.vkatit.lesson15_2;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread...");

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Start 10 threads: " + Thread.currentThread().getName() + " process...");

                int a = (int) (Math.random() * 1_000_000);
                ArrayList<Integer> number = new ArrayList<Integer>();
                number.add(a);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Finished threads: " + "random number -> " + number);
            }
        });
        executor.shutdown();
    }
}