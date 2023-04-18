package com.vkatit.lesson15;

public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String s) {
        this.command = s;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start -> process = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " Finish");
    }
    private void processCommand() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String toString() {
        return this.command;
    }
}