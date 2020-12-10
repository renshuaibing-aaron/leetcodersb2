package com.aaron.ren.leetcode;

import java.util.LinkedList;

public class MyStack {


    //这个和用两个栈实现队列不一样啊  这个每次操作会清空
    private static LinkedList<Integer> queue;
    private static LinkedList<Integer> tmp;

    /** Initialize your data structure here. */
    public MyStack() {
        queue=new LinkedList<Integer>();
        tmp=new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
       if(!queue.isEmpty()){
           queue.push(x);
       }
       if(!tmp.isEmpty()){
           tmp.push(x);
       }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result=0;
        while(!queue.isEmpty()){
            if(queue.size()==1){
                result= queue.poll();

            }else{
                tmp.push(queue.poll());
            }
        }
        while(!tmp.isEmpty()){
            if(tmp.size()==1){
                result= tmp.poll();

            }else{
                queue.push(tmp.poll());
            }
        }
        return result;
    }

    /** Get the top element. */
    public int top() {
        //只是获取top
        int result=0;
        while(!queue.isEmpty()){
            if(queue.size()==1){
                result= queue.peek();
                tmp.push(queue.poll());
            }else{
                tmp.push(queue.poll());
            }
        }
        while(!tmp.isEmpty()){
            if(tmp.size()==1){
                result= tmp.peek();
                queue.push(tmp.poll());
            }else{
                queue.push(tmp.poll());
            }
        }
        return result;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
    return queue.isEmpty();
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
