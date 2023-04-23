package com.vkatit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BlockingQueue {

    private final Queue<String> queue = new LinkedList<>();

    private final Integer MAX_CAPACITY;
    private final Object lock = new Object();

    public BlockingQueue(Integer capacity) {
        this.MAX_CAPACITY = capacity;
    }

    public String poll() {
        synchronized (lock) {
            while (true) {
                if (!queue.isEmpty()) {
                    System.out.println("has something to pool: " + queue.size() + " from reader: " + Thread.currentThread().getName());
                    lock.notifyAll();
                    return queue.poll();
                } else {
                    try {
                        System.out.println("has nothing to pool: " + queue.size() + " from reader: " + Thread.currentThread().getName());
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public void push(String newRecord) {
        synchronized (lock) {
            while (true) {
                if (queue.size() < MAX_CAPACITY) {
                    System.out.println("has capacity: " + queue.size() + " from pusher: " + Thread.currentThread().getName());
                    queue.add(newRecord);
                    lock.notifyAll();
                    break;
                } else {
                    try {
                        System.out.println("has no capacity: " + queue.size() + " from pusher : " + Thread.currentThread().getName() + " sleeping");
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    ReentrantLock reentrantLock = new ReentrantLock();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    final Condition notFull = reentrantLock.newCondition();
    final Condition notEmpty = reentrantLock.newCondition();

    public void read() {
        try {
            readWriteLock.readLock();

            queue.peek();

        } finally {
            readWriteLock.readLock();
        }
    }
    public void write(String data) {
        try {
            readWriteLock.writeLock();

            queue.add(data);

        } finally {
            readWriteLock.writeLock();
        }
    }
}