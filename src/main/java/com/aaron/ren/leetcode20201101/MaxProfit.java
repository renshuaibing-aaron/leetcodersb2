package com.aaron.ren.leetcode20201101;

public class MaxProfit {


//    股票的最大利润
    // 这个特么 也配叫动态规划
    public int maxProfit(int[] prices) {

        if(prices.length<=1){
            return 0;
        }
        int res=0;
        int min=prices[0];

        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            res=Math.max(res,prices[i]-min);
        }
return res;
    }
}
