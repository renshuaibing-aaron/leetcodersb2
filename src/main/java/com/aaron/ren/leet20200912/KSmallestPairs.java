package com.aaron.ren.leet20200912;

import java.util.*;

public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //针对数组中和的最小值 进行排序 然后输出k对
        //很朴素的思想  直接使用大顶堆  这里注意 堆里面可以方数组 牛逼
        List<List<Integer>> res = new ArrayList<>();
        k = Math.min(k,nums1.length*nums2.length); //注意k的取值
        if(k==0) {
            return res;
        }

        Queue<int[]> queue = new PriorityQueue<>(k,(o1, o2)->o2[0]+o2[1]-o1[0]-o1[1]);
        for(int e1:nums1) {
            for(int e2:nums2){
                if(queue.size()<k) {
                    queue.offer(new int[]{e1,e2});
                }else if(e1+e2<=queue.peek()[0]+queue.peek()[1]){
                    queue.poll();
                    queue.offer(new int[]{e1,e2});
                }
            }
        }
        while(k-->0){
            int[] e = queue.poll();
            res.add(0, Arrays.asList(e[0],e[1]));
        }

        return res;

    }
}
