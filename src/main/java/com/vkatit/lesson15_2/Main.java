package com.vkatit.lesson15_2;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Start thread " + Thread.currentThread().getName() + "process");

                int a = (int) (Math.random() * 1_000_000);

                ArrayList<Integer> number = new ArrayList<Integer>();
                number.add(a);
            }
        }, "ivan thread");
    }
}