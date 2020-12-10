package com.aaron.ren.zhuanxiang.packet;

import java.util.LinkedList;
import java.util.PrimitiveIterator;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    static class MyQueue {

        private Queue<Integer> queue = new LinkedList<>();

        private PrimitiveIterator.OfLong longs = new Random().longs(10, 200).iterator();

        private Lock lock = new ReentrantLock();

        private Condition b = lock.newCondition();
        private Condition c = lock.newCondition();
        private Condition d = lock.newCondition();


        //线程B消费所有被3整除的数
        //看看这些个返回值是什么呢
        public int b_pull() {
            lock.lock();
            try {
                try {
                    b.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
            return queue.remove();
        }

        //线程C消费所有被5整除的数
        public int c_pull() {
            lock.lock();
            try {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
            return queue.remove();
        }

        //其它的由线程D进行消费
        public int d_pull() {
            lock.lock();
            try {
                try {
                    d.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
            return queue.remove();
        }

        public void start() {
            new Thread(() -> {
                for (int i = 1; i <= 100; i++) {
                    queue.add(i);
                    lock.lock();
                    try {
                        if (i % 3 == 0) {
                            b.signal();
                        } else if (i % 5 == 0) {
                            c.signal();
                        } else {
                            d.signal();
                        }
                    } finally {
                        lock.unlock();
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(longs.nextLong());
                    } catch (InterruptedException ignore) {

                    }
                }
                System.out.println("all numbers are produced.");
            }).start();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        new Thread(() -> {
            while (true) {
                System.out.println(String.format("B(mod 3) consume : %d", queue.b_pull()));
            }
        }).start();
        new Thread(() -> {
            while (true) {
                System.out.println(String.format("C(mod 5) consume : %d", queue.c_pull()));
            }
        }).start();
        new Thread(() -> {
            while (true) {
                System.out.println(String.format("D(other) consume : %d", queue.d_pull()));
            }
        }).start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queue.start();
    }
}