package com.domain.intro;

import java.util.concurrent.TimeUnit;

public class MainDemo {
    public static void main(String[] args) {

        Runnable myRunnable = () -> {

            for (int i = 1; i < 8; i++) {
                System.out.print(" 3 ");

                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread mythread = new Thread(myRunnable);
        mythread.start();

        Thread th1 = new CustomThread();
        th1.start();

        // to show that this is all happening concurrently -
        // simultanously... each doing its thing without waiting on eachother

        for (int i = 0; i < 8; i++) {
            System.out.print(" 2 ");
            try {
                TimeUnit.SECONDS.sleep(1); // adding a one-second sleep on the main thread after every count print
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void printThreadState(Thread thread) {

        System.out.println("----------------------------------------------------");
        System.out.printf("Current thread ID: %d\n", thread.getId());
        System.out.printf("Current thread name: %s\n", thread.getName());
        System.out.printf("Current thread state: %s\n", thread.getState());
        System.out.printf("Current thread priority: %d\n", thread.getPriority());
        System.out.printf("Is Current thread Alive: %s\n", thread.isAlive());
        System.out.printf("Current thread group: %s\n", thread.getThreadGroup().getName());
        System.out.printf("Is Current thread Interrupted: %s\n", thread.isInterrupted());
        System.out.println("----------------------------------------------------");

    }
}
