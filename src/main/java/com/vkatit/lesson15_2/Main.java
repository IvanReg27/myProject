package com.vkatit.lesson15_2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main thread...");

        Thread ivanThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Start thread: " + Thread.currentThread().getName() + " process...");

                int a = (int) (Math.random() * 1_000_000);

                ArrayList<Integer> number = new ArrayList<Integer>();
                number.add(a);

                System.out.println("Finished thread: " + "random number -> " + number);
            }
        }, "ivan thread");
        ivanThread.start();
    }
}