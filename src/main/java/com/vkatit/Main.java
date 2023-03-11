package com.vkatit;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.io.File;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

// visibility, atomicity, orderding, happens before

    public static int value = 0;

    private static final Queue<Runnable> workers = new LinkedList<>();
    private static Thread mainThread = null;
    List<Integer> simleNumbers = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {

        System.out.println("init");
        mainThread = Thread.currentThread();

        Thread vasyaThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("keke");
                }
            }
        }, "vasya thread");

        vasyaThread.setDaemon(true);
        vasyaThread.start();
////        ExecutorService service = Executors.newFixedThreadPool(3);
//        ExecutorService service = Executors.newCachedThreadPool();
//
//        service.submit(new Runnable() {
//            @Override
//            public void run() {
//
//
//
//            }
//        });
//
//        service.shutdown();


//        Integer[] myIntegerArray = new Integer[Integer.MAX_VALUE];
//        Integer myVal  = 123;
//        printMe(myVal);
//        myVal = 555;
//        int myPrimitiveValue = 123;
//        File file = new File("keke");
    }

    private static void printMe(Integer someValue) {
        Integer myVal = 333;
        String someString = "kekee";
        System.out.println(someValue);
    }

}
