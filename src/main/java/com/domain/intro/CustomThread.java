package com.domain.intro;

public class CustomThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i < 6; i++) {
            System.out.print("1  ");
            try {
                Thread.sleep(1000); // Adding a 1 -second delay btn each count print
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
