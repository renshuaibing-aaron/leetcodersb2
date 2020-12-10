package com.aaron.ren.zhuanxiang.myqueuestack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//以o1 获取队列的最大值
public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQueue = new LinkedList<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : maxQueue.getFirst();
    }

    //
    public void push_back(int value) {
        while(maxQueue.size() > 0 && value > maxQueue.getLast()){
            maxQueue.removeLast();
        }
        queue.add(value);
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        if(queue.peek().equals(maxQueue.getFirst())){ //Integer 不可以直接比较
            maxQueue.removeFirst();
        }
        return queue.poll();
    }

}
