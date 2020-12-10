package com.aaron.ren.zhuanxiang.myqueuestack;

import java.util.Stack;


//栈的最小值 栈的最大值
//队列的最小值 队列的最大值
//利用队列实现栈
//利用栈实现队列
//https://blog.csdn.net/weixin_33737774/article/details/85967494
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()||minStack.peek() >= x) {
            minStack.push(x);

        }
    }

    public void pop() {

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return 0;
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
