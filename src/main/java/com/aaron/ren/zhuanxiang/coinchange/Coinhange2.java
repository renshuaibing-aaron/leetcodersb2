package com.aaron.ren.zhuanxiang.coinchange;

public class Coinhange2 {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[][] dp = new int[len][amount + 1];
        // 题解中有说明应该如何理解这个初始化
        dp[0][0] = 1;

        // 填第 1 行
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; j - k * coins[i] >= 0; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[len - 1][amount];
    }
}
