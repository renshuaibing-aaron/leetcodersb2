package com.aaron.ren.leetcode20201102;

import java.util.Arrays;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
     //最长不连续的递增子序列
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);

        int res=1;

        //注意这个动态规划的思路  的确是比较简单的思路
        //
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                //转移方程怎么转换
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            res=Math.max(res,dp[i]);
        }
        return  res;

    }
}
