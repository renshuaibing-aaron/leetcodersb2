package com.aaron.ren.zhuanxiang.myqueuestack;

import java.util.Stack;

public class MaxStack {

    Stack<Integer>  stack;
    Stack<Integer>  maxStack;
    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);
        if(maxStack.peek()<=x){
            maxStack.push(x);
        }
    }

    public void pop() {

        if(maxStack.peek().equals(stack.peek())){
            maxStack.pop();
        }
         stack.pop();
    }

    public int top() {
       return stack.pop();
    }

    public int getMax() {
       return maxStack.peek();
    }
}
