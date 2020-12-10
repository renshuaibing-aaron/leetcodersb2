package com.aaron.ren.leet20200915;

import java.util.concurrent.CountDownLatch;

public class DeadLock {



    private static String threadA="threadA";
    private static String threadB="threadB";


    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (threadA) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (threadB) {
                        }
                    }

                }

            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (threadB){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (threadA){

                        }
                    }

                }

            }
        }, "B").start();


  new CountDownLatch(1).await();
    }
}
