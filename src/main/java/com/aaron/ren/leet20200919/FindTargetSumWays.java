package com.aaron.ren.leet20200919;

import java.util.Deque;
import java.util.LinkedList;

public class FindTargetSumWays {
    //目标和 明显用回溯的方法
    public int findTargetSumWays(int[] nums, int S) {

        int length = nums.length;

        Deque<Integer>  deque=new LinkedList<>();

        int res=0;

        dfs(nums,deque,res);
        return res;

    }

    private void dfs(int[] nums, Deque<Integer> deque, int res) {
        if(deque.size()==nums.length){
            res++;
            return;
        }

        for(int i=0;i<nums.length;i++){

            deque.addLast(nums[i]);
            dfs(nums,deque,res);
            deque.removeLast();
        }

    }
}
