package com.vkatit.lesson15;

public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String s) {
        this.command = s;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start / command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End");
    }
    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String toString() {
        return this.command;
    }
}