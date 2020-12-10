package com.aaron.ren.zhuanxiang.zhuanxiangLCS;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/21 23:50
 */

public class FindLengthOfLCIS {


    //最长的连续递增子序列
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int[] dp=new int[nums.length];
        dp[0]=1;

        int res=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=1;
            }
            res=Math.max(res,dp[i-1]);
        }
        return res;

    }

}
