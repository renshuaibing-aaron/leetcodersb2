package com.aaron.ren.zhuanxiang.packet;

import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;
    private int i;

    public ZeroEvenOdd(int n) {
        this.n = n;
        i=1;
    }

    public static void main(String[] args) {

        ZeroEvenOdd zeroEvenOdd=new ZeroEvenOdd(5);

        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(new PrintNumber());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(new PrintNumber());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(new PrintNumber());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true){
           if(i<=n){
               printNumber.accept(0);
               i++;
           }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

    }

    private static class PrintNumber implements IntConsumer {
        @Override
        public void accept(int value) {
            System.out.println(value);
        }
    }
}
