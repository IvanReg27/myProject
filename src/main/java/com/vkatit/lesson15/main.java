package com.vkatit.lesson15;

public class main {

    public static void main(String[] args) {

        Thread ivanThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Main thread created: " + Thread.currentThread().getName());
            }
        }, "ivanThread");
        ivanThread.start();
    }
}