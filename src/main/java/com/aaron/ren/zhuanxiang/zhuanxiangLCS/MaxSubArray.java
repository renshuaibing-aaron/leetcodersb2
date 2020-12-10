package com.aaron.ren.zhuanxiang.zhuanxiangLCS;

/*
最大连续子序列的和
 */
public class MaxSubArray {


    public int maxSubArray(int[] nums) {

        int res=nums[0];
        //dp表示以 i结尾的数组和
        int[] dp=new int[nums.length];
        dp[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }

        return res;
    }
   // 最大连续子序列的和
    public int maxSubArray2(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int res=nums[0];
        int[] dp =new int[nums.length];
        dp[0]=res;
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(dp[i],res);
        }
        return  res;

    }
}
