package com.aaron.ren.leet20200912;

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> queue=new PriorityQueue<>();
    private int limit;

    public KthLargest(int k, int[] nums) {

        //构造器 初始化数组 和k
        //可定可以想到用堆 但是为什么用最小堆呢
        //可以想象 假如 获取水流中的最大值 很简单 直接 保留最大值即可
        //获取第K大值 那么 保留一个K大值的数组  每次新进入的数和这k个数中的最下值进行比较即可
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }

    }

    public int add(int val) {
        //插入数据  返回k大值
        if(limit>queue.size()){
            queue.add(val);

            //获取k个之中最小值
        }else if(val>queue.peek()){
            //删除队列头部的值
        queue.poll();
        queue.add(val);
        }

        return queue.peek();

    }

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */
}
