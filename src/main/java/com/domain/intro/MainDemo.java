package com.domain.intro;

import java.util.concurrent.TimeUnit;

public class MainDemo {
    public static void main(String[] args) {


        Thread printingThread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.printf("%s is supposed to print 10 dots\n", threadName);
            for (int i = 0; i < 10; i++) {
                System.out.print(". ");
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                } catch (InterruptedException e) {
                    System.out.printf("Whoops!! %s was interrupted\n", threadName);
                }
            }
        }, "DOT PRINTING THREAD");

        printingThread.start();

        Thread installingThread = new Thread(() -> {
            System.out.printf("%s is started\n", Thread.currentThread().getName());

            for (int i = 0; i < 5; i++) {
                System.out.printf("Installing %d completed\n", i + 1);
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "INSTALLING THREAD");

        Thread monitorThread = new Thread(() -> {

            long now = System.currentTimeMillis();

            while (printingThread.isAlive()) {
                System.out.println("\nWaiting for printing thread to finish");
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);

                    if (System.currentTimeMillis() - now > 2000){
                        printingThread.interrupt();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "MONITOR THREAD");

        monitorThread.start();

        try {
            printingThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!printingThread.isInterrupted()) {
            installingThread.start();
        } else {
            System.out.printf("Previous thread -->> %s was interrupted%n, %s Cannot run", Thread.currentThread().getName(), installingThread.getName());
        }


    }

    private static void updateIntro() {

        System.out.println("Hello World -->> Main thread is Running");

        try {
            System.out.println("The main thread is Paused for one second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is should take 10 dots to run.");

            for (int i = 0; i < 10; i++) {
                System.out.print(". ");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("\nWhoops!! " + threadName + " was interrupted");
                    return;
                }
            }
            System.out.println("\n" + threadName+ " completed.");
        });

        System.out.println(thread.getName() + " is starting.");
        thread.start();

        System.out.println("The main thread is Resumed");
    }

    private static void intro() {
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
