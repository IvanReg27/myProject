package com.vkatit.lesson15_3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPollRecFile {

    ExecutorService executor = Executors.newFixedThreadPool(10);
    SimpleDateFormat sdf = null;
    private  final  int  COUNT = 5;
    ThreadPollRecFile() {

        sdf = new SimpleDateFormat("HH:mm:ss.S");

        CountDownLatch cdl1 = new CountDownLatch(COUNT);
        CountDownLatch cdl2 = new CountDownLatch(COUNT);
        CountDownLatch cdl3 = new CountDownLatch(COUNT);
        CountDownLatch cdl4 = new CountDownLatch(COUNT);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("Start threads...");

        executor.execute(new ThreadPollRecFile.MyThread(cdl1, "Thread_1"));
        executor.execute(new ThreadPollRecFile.MyThread(cdl2, "Thread_2"));
        executor.execute(new ThreadPollRecFile.MyThread(cdl3, "Thread_3"));
        executor.execute(new ThreadPollRecFile.MyThread(cdl4, "Thread_4"));

        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch(InterruptedException exc) {
        }
        executor.shutdown();

        System.out.println("Finished threads");
    }
    void printMessage(final String templ) {
        String text = sdf.format(new Date()) + " : " + templ;
        System.out.println(text);
    }
    class MyThread implements Runnable {
        String name;
        CountDownLatch latch;
        MyThread(CountDownLatch c, String n) {
            latch = c;
            name = n;
            new Thread(this);
        }
        public void run() {
            try {
                //---------------------------------------------------------
                int a = (int) (Math.random() * 1_000_000);
                ArrayList<Integer> number = new ArrayList<Integer>();
                number.add(a);
                //---------------------------------------------------------





                for(int i = 0; i < COUNT; i++) {
                    printMessage(name + " - " + number);
                    latch.countDown();
                    Thread.sleep((int)(Math.random() * 1500));
                }
                printMessage(name + " completed");
            } catch (InterruptedException e) {}
        }
    }
    public static void main(String args[]) {
        new ThreadPollRecFile();
    }
}