package com.aaron.ren.leet20200914;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SubarraySum {

    public static void main(String[] args) {
        int [] nums={1,2,4};
        System.out.println(subarraySum(nums, 5));
    }

    //输入:nums = [1,1,1], k = 2
    //输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
    //和为K的连续子数组 怎么实现呢
    public static int subarraySum(int[] nums, int k) {
        //使用回溯法
        List<List<Integer>>  res=new ArrayList<>();

        Deque<Integer> path=new LinkedList<>();

        dfs(nums,0,0,k,path,res);
        System.out.println(res);
        return res.size();

    }

    private static  void dfs(int[] nums, int index, int sum, int target, Deque<Integer> path,List<List<Integer>>  res) {
        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }else if(sum>target){
            return;
        }else{
            for(int i=index;i<nums.length;i++){
                path.addLast(nums[i]);
                sum=sum+nums[i];
                //这里肯定出问题了 不是求全排列 是连续的数组实现啊
                //这里无法实现
                dfs(nums, i+1, sum, target, path, res);
                path.removeLast();
                sum=sum-nums[i];

            }
        }


    }
}
