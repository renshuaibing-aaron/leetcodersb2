package com.aaron.ren.leetcode20201102;

import java.util.Arrays;

public class FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        //最长连续递增子序列
        if(nums.length<2){
            return nums.length;
        }
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int res=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
            res=Math.max(dp[i],res);
        }
        return res;
    }
}
