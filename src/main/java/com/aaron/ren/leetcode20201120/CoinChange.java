package com.aaron.ren.leetcode20201120;

import java.util.Arrays;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/21 17:01
 */

public class CoinChange {

    //零钱兑换  硬币是无限的  求最少的硬币个数
    //背包问题
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
