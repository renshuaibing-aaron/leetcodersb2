package com.aaron.ren.leet20200913;

public class ClimbStairs {


    /*
    * 1  1   dp(1)=1
    * 2  1+1 2  dp(2)=2
    * 3  dp(3)=dp(3-1)+dp(3-2)
    *
    * 4  dp(4)=dp(3)+dp(2)
    *
    *
    *
    * */

    public int climbStairs(int n) {
        if(n==0)  return 0;
        if(n==1)  return 1;
        if(n==2)  return 2;

        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }

        return dp[n];
    }
}
