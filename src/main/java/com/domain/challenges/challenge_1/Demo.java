package com.domain.challenges.challenge_1;

import java.util.concurrent.TimeUnit;


class OddThread extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 10; i+=2) {
            System.out.println("Odd ->> " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("OddThread Interrupted!");
                break;
            }
        }
    }
}

public class Demo {
    public static void main(String[] args) {

        Thread threadOne = new OddThread();  // prints 5 even numbers

        Thread threadTwo = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {

                if (i % 2 == 0) {
                    System.out.println("Even -> " + i);
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("EvenThread Interrupted!");
                    }
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        // giving the threads sometime to execute
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace(); // dont just print but fiure out how to handle it
        }

        threadOne.interrupt();
    }
}
