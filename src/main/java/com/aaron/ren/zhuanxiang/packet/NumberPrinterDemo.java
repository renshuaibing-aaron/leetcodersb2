package com.aaron.ren.zhuanxiang.packet;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NumberPrinterDemo {

    private volatile int start;
    private volatile int end;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        NumberPrinterDemo numberPrinter = new NumberPrinterDemo(1, 100);

        Thread threadA = new Thread(new RunableA(numberPrinter), "A");
        Thread threadB = new Thread(new RunnableB(numberPrinter), "B");
        threadA.start();
        threadB.start();
    }

    public NumberPrinterDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 怎么判读是不是子树呢
    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }



    public void printPrime() {
        try {
            lock.lock();
            while (start < end) {
                System.out.println("质数:::" + start);
                while (!isPrime(start) && start < end) {
                    System.out.println("质数--等待" + start);
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + " 质数: " + start);
                start++;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printOther() {
        try {
            lock.lock();
            while (start < end) {
                System.out.println("其他:::" + start);
                while (isPrime(start) && start < end) {
                    System.out.println("其他--等待" + start);
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + " 非质数: " + start);
                start++;
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

  static   class RunableA implements Runnable {
        private NumberPrinterDemo numberPrinter;

        public RunableA(NumberPrinterDemo numberPrinter) {
            this.numberPrinter = numberPrinter;
        }

        @Override
        public void run() {
            numberPrinter.printPrime();
        }
    }

    static  class RunnableB implements Runnable {
        private NumberPrinterDemo numberPrinter;

        public RunnableB(NumberPrinterDemo numberPrinter) {
            this.numberPrinter = numberPrinter;
        }

        @Override
        public void run() {
            numberPrinter.printOther();
        }
    }
}
