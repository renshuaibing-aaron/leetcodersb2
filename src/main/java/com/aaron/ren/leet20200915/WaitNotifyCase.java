package com.aaron.ren.leet20200915;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class WaitNotifyCase {
    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread B get lock");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //notify方法会选择wait set中任意一个线程进行唤醒
                    lock.notify();
                    //notifyAll方法会唤醒monitor的wait set中所有线程。
                    lock.notifyAll();
                    //执行完notify方法，并不会立马唤醒等待线程，在notify方法后面加一段sleep代码就可以看到效果，如果线程B执行完notify方法之后sleep 5s，在这段时间内，线程B依旧持有monitor，线程A只能继续等待；
                    System.out.println("thread B do notify method");
                }
            }
        }).start();

        Thread.sleep(10000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread A get lock");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("thread A do wait method");
                        //表示线程执行lock.wait()方法时，必须持有该lock对象的monitor，如果wait方法在synchronized代码中执行，
                        // 该线程很显然已经持有了monitor
                        lock.wait();
                        //wait方法会将当前线程放入wait set，等待被唤醒，
                        // 并放弃lock对象上的所有同步声明，意味着线程A释放了锁，线程B可以重新执行加锁操作
                        System.out.println("wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();



        new CountDownLatch(1).wait();
    }
}