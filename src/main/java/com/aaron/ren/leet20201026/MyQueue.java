package com.aaron.ren.leet20201026;

import java.util.Stack;

public class MyQueue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);

        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());

        System.out.println(myQueue.stackin);
        System.out.println(myQueue.stackout);

        System.out.println(myQueue.empty());
    }

    Stack<Integer> stackin;
    Stack<Integer> stackout;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stackin = new Stack<>();
        stackout = new Stack<>();

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackin.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // 出栈
        if(!stackout.isEmpty()){
            return stackout.pop();
        }else{
            while(!stackin.isEmpty()){
                stackout.push(stackin.pop());
            }
            return stackout.pop();
        }
    }

    /*
     * Get the front element. */
    public int peek() {
        if(!stackout.isEmpty()){
            return stackout.peek();
        }else{
            while(!stackin.isEmpty()){
                stackout.push(stackin.pop());
            }
            return stackout.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {

  return stackout.isEmpty()&&stackin.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */