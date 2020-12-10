package com.aaron.ren.leetcode20201101;

import java.util.*;

public class Solution {
    //滑动敞口最大值
    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> tmp=new ArrayList<>();
        Deque<Integer>  dequeue=new LinkedList<>();

        int max=Integer.MIN_VALUE;
         for(int i=0;i<k;i++){
            max=Math.max(max,nums[i]);
            dequeue.addFirst(nums[i]);
         }
        tmp.add(max);

         for(int j=k;j< nums.length;j++){
             int max2=Integer.MIN_VALUE;

             for(Integer item :dequeue){
                 max2=Math.max(item,max2);
             }

             dequeue.addFirst(nums[j]);
             dequeue.removeLast();
             //这个时候的最大值如何变化
             tmp.add(max2);
         }
        int[] res = new int[nums.length - k + 1];

         for(int i=0;i<res.length;i++){
             res[i]=tmp.get(i);
         }
    return res;

    }
}
