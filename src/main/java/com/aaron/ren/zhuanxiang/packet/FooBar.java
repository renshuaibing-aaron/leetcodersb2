package com.aaron.ren.zhuanxiang.packet;

import java.util.concurrent.Semaphore;

class FooBar {


    //先打印foo  再打印bar

    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);


    public static void main(String[] args) {

        FooBar fooBar=new FooBar(3);
      Thread threadA =new Thread(new Runnable() {
          @Override
          public void run() {
              try {
                  fooBar.foo(new PrintFoo());
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      });
      Thread threadB =new Thread(new Runnable() {
          @Override
          public void run() {
              try {
                  fooBar.bar(new PrintBar());
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      });
        threadA.start();
        threadB.start();
    }




    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            fooSemaphore.acquire();
            printFoo.run();
            barSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            barSemaphore.acquire();
            printBar.run();
            fooSemaphore.release();
        }
    }

    private static class PrintFoo implements Runnable {

        @Override
        public void run() {
            System.out.println("foo");
        }
    }

    private static class PrintBar implements Runnable {
        @Override
        public void run() {
            System.out.println("bar");
        }
    }
}