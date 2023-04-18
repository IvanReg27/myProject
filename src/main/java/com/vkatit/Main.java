package com.vkatit;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

// visibility, atomicity, orderding, happens before

    private static final Queue<Runnable> workers = new LinkedList<>();
    private static Thread mainThread = null;
    List<Integer> simleNumbers = new ArrayList<>();

    private static AtomicInteger myAtomic = new AtomicInteger(0);
    private static List<String> myList = new CopyOnWriteArrayList<>();
    private static Map<String, String> map = new ConcurrentHashMap<>();
    static final Object lock = new Object();

    static List<Thread> allThreads = new CopyOnWriteArrayList<>();
    static long value = 0;
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue blockingQueue = new BlockingQueue(100);

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    blockingQueue.push(UUID.randomUUID().toString());
                }
            }, "pusher" + i);
            thread.start();

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    blockingQueue.poll();
                }
            }, "pooler" + i);
            thread1.start();
        }
//        for (int i = 0; i < 100; i++) {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    while (value < 10_000) {
//                        write();
//                    }
//                }
//            }, "writer" + i);
//            allThreads.add(thread);
//            thread.start();
//        }

//        for (int i = 0; i < 200; i++) {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    read();
//                }
//            },"reader" + i);
//            allThreads.add(thread);
//            thread.start();
//        }

    }
    private static void write() {
        synchronized (lock) {
            value = value + 1;
            System.out.println("increased value to: " + value + " by thread: " + Thread.currentThread().getName());
        }
    }
//    static ReentrantLock reentrantLock = new ReentrantLock(true);

//    private static void writeFair() {
//        try {
//            reentrantLock.lock();
//            value = value + 1;
//            System.out.println("increased value to: " + value + " by thread: " + Thread.currentThread().getName());
//        } finally {
//            reentrantLock.unlock();
//        }
//    }
    private static void read() {
        synchronized (lock) {
            System.out.println(value);
        }
    }
}