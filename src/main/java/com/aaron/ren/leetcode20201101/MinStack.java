package com.aaron.ren.leetcode20201101;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer>  helpstack;

    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        helpstack=new Stack<>();

    }

    public void push(int x) {
       stack.push(x);
       if(helpstack.isEmpty()||helpstack.peek()>x){
           helpstack.push(x);
       }
    }

    public void pop() {
        Integer pop = stack.pop();
        if(helpstack.peek().equals(pop)){
            helpstack.pop();
        }
    }

    public int top() {
     return stack.peek();
    }

    public int min() {
        return helpstack.peek();
    }
}
