package com.vkatit.lesson15_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

//Тренировака на одном созданом потоке и передачей нагенеренного параметра
public class ThreadRunnable {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread...");

        Thread ivanThread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Start thread: " + Thread.currentThread().getName() + " process...");

                int a = (int) (Math.random() * 1_000_000);
                List<Integer> number = new CopyOnWriteArrayList<>();
                number.add(a);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Finished thread: " + "random number -> " + number);
            }
        }, "ivan thread");
        ivanThread.start();
    }
}