package com.aaron.ren.leetcode20201120;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/21 0:05
 */

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int res=nums[0];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }


        return res;
    }


}
