package com.aaron.ren.leet20200910.testthread;

import java.util.concurrent.Semaphore;

//交替打印ABC
public class PrintABC {

    private static  Semaphore semaphoreA =new Semaphore(1);
    private static Semaphore semaphoreB =new Semaphore(0);
    private static Semaphore semaphoreC =new Semaphore(0);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        semaphoreA.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A");
                    semaphoreB.release();
                }

            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        semaphoreB.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("B");
                    semaphoreC.release();
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        semaphoreC.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("C");
                    semaphoreA.release();
                }
            }
        },"C").start();

    }
}
