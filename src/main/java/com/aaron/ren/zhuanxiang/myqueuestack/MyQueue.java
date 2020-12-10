package com.aaron.ren.zhuanxiang.myqueuestack;

import java.util.Stack;

class MyQueue {

    //用栈来实现队列比较容易
    Stack<Integer> stackin;
    Stack<Integer>  stackout;

    /** Initialize your data structure here. */
    public MyQueue() {
      stackin=new Stack<>();
      stackout=new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackin.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackout.isEmpty()) {
            while (!stackin.isEmpty()) {
                stackout.push(stackin.pop());
            }

        }
        return stackout.pop();
    }


    /** Get the front element. */
    public int peek() {
        if(stackout.isEmpty()) {
            while (!stackin.isEmpty()) {
                stackout.push(stackin.pop());
            }

        }
        return stackout.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
return stackin.isEmpty()&&stackout.isEmpty();
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