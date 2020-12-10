package com.aaron.ren.zhuanxiang.zhuanxiangLCS;

import java.util.Arrays;

//最长递增子序列
public class LengthOfLIS {

    //如果是返回值是返回最长的递增子序列怎么办

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
