package com.aaron.ren.leet20200914;

import java.util.Deque;
import java.util.LinkedList;

class MyStack {

    private Deque<Integer>  queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue =new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return queue.getLast();
    }

    /** Get the top element. */
    public int top() {
        Integer last = queue.getLast();
        queue.removeLast();
        return last;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return  queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
