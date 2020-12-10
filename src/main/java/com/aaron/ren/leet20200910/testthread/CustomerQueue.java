package com.aaron.ren.leet20200910.testthread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 自定义队列
 * 这个队列能够在10 秒到100秒的按顺序生成 0-100的随机数
 * <p>
 * 这个队列被三个线程共享
 * 这个队列 提供三个方法 分别被三个线程调用 然后
 * A线程 只打印被三整除的数
 * B线程只打印被五整除的数
 * C线程打印其他的数
 */
public class CustomerQueue {

    private Queue<Integer> queue = new LinkedList<>();
    // 这里用这个信号量实现
    private Semaphore semaphoreA=new Semaphore(0);
    private Semaphore semaphoreB=new Semaphore(0);
    private Semaphore semaphoreC=new Semaphore(0);

    public void pullA() throws InterruptedException {
        while(true){
            semaphoreA.acquire();
            Integer poll = queue.poll();
            System.out.println("线程"+Thread.currentThread()+poll);
        }

    }

    public void pullB() throws InterruptedException {
        while(true){
            semaphoreB.acquire();
            Integer poll = queue.poll();
            System.out.println("线程"+Thread.currentThread()+poll);
        }
    }

    public void pullC() throws InterruptedException {
        while(true){
            semaphoreC.acquire();
            Integer poll = queue.poll();
            System.out.println("线程"+Thread.currentThread()+poll);
        }
    }

    public void createNum() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                   // System.out.println("生产线程"+Thread.currentThread()+queue);
                    queue.offer(i);

                    if(i%3==0&&i%5!=0){
                        semaphoreA.release();
                    }else if(i%3!=0&&i%5==0){
                        semaphoreB.release();
                    }else{
                        semaphoreC.release();
                    }

                    try {
                        //随机休息的的情况下 进行生产数据
                        TimeUnit.MILLISECONDS.sleep(new Random().longs(10, 200).iterator().nextLong());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"生产").start();
    }

    public static void main(String[] args) {
        CustomerQueue customerQueue=new  CustomerQueue();
        customerQueue.createNum();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    customerQueue.pullA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    customerQueue.pullB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    customerQueue.pullC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();


    }

}
