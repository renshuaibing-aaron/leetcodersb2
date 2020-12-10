package com.aaron.ren.zhuanxiang.packet;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz=new FizzBuzz(15);

        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizz(new PrintFizz());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.buzz(new PrintBuzz());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadC=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.fizzbuzz(new PrintFizzBuzz() );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadD=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fizzBuzz.number(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }

    public FizzBuzz(int n) {
        //从 1 开始
        this.i = 1;
        this.n = n;
    }

    private int n;

    Semaphore fizzSem = new Semaphore(0);
    Semaphore buzzSem = new Semaphore(0);
    Semaphore fizzBuzzSem = new Semaphore(0);
    Semaphore numSem = new Semaphore(1);

    private int i;



    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizzSem.acquire();
            if (i > n) {
                break;
            }
            printFizz.run();
            i++;
            numSem.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            buzzSem.acquire();
            if (i > n) {
                break;
            }
            printBuzz.run();
            i++;
            numSem.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            fizzBuzzSem.acquire();
            if (i > n) {
                break;
            }
            printFizzBuzz.run();
            i++;
            numSem.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        ///主要是这儿执行完后其他的还在等，所以会超时，这个时候释放掉所有的就行了。
        while (i <= n) {
            numSem.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzSem.release();
            } else if (i % 3 == 0) {
                fizzSem.release();
            } else if (i % 5 == 0) {
                buzzSem.release();
            } else {
                if (i <= n) {
                    printNumber.accept(i);
                }
                i++;
                numSem.release();
            }
        }
        release(); // 最终释放许可
    }

    private void release() {
        fizzBuzzSem.release();
        buzzSem.release();
        fizzSem.release();
    }

    private static class PrintFizz implements Runnable {
        @Override
        public void run() {
            System.out.println("fizz");
        }
    }

    private static class PrintBuzz implements Runnable {
        @Override
        public void run() {
            System.out.println("buzz");
        }
    }

    private static class PrintFizzBuzz implements Runnable {
        @Override
        public void run() {
            System.out.println("fizzbuzz");
        }
    }
}
