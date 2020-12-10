package com.aaron.ren.zhuanxiang.myqueuestack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/21 13:48
 */

public class MinQueue {

    private Queue<Integer> queue = new LinkedList<Integer>();
    private Stack<Integer> minQueue = new Stack<Integer>();

    public void push(int x) {
        queue.offer(x);
        if (minQueue.isEmpty() || x <= minQueue.peek())
            minQueue.add(x);
    }

    public void pop() {
        int value = queue.poll();
        if (value == minQueue.peek())
            minQueue.pop();
    }

    public int top() {
        return queue.peek();
    }

    public int getMin() {
        return minQueue.peek();
    }

    public static void main(String[] args) {
        MinQueue queue = new MinQueue();
        queue.push(5);
        queue.push(4);
        queue.push(3);
        queue.push(6);
        queue.push(7);
        System.out.println(queue.getMin());
        queue.pop();
        queue.pop();
        queue.pop();
        System.out.println(queue.getMin());
    }
}
