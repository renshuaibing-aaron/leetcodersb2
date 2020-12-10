package com.aaron.ren.leetcode20201028;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins={1,2,5};
        int i = coinChange(coins, 11);
        System.out.println(i);
    }
    public int coinChange2 (int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    //零钱兑换  2  3
    public static  int coinChange(int[] coins, int amount) {
        //需要用动态规划 关键是设置多少个数组呢
        int[] res=new int[amount+1];

        Arrays.fill(res,amount+1);

        res[0]=0;
      //  res[1]=Min{res[1-0],res[1-2],res[1-5]} +1

        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                 if(i-coin>=0){
                     res[i]=Math.min(res[i],res[i-coin]+1);
                 }
            }
        }

        return res[amount]>amount?-1:res[amount];
    }
}
