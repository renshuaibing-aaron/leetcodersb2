package com.aaron.ren.leetcode20201101;

import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

   Queue<Integer>  queue;
   int max=-1;

    public MaxQueue() {
        queue=new LinkedList<>();
    }

    //最大值队列 注意和最小值的栈 进行比较
    public int max_value() {
        return  max;
    }

    public void push_back(int value) {
        queue.offer(value);
        max=Math.max(max,value);

    }

    public int pop_front() {
        Integer poll = queue.poll();



        return 0;
    }
}
