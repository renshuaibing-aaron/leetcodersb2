package com.aaron.ren.leet20200920;

public class NumWays {
    /**
     * dp[i] 用来表示i个栅栏柱的涂色的方案数，有两种情况：
     * 如果：i与i-1的颜色相同，则表明i-1与i-2的颜色不同，则i的数目为dp[i-2]*(k-1)
     * 如果：i与i-1的颜色不同，则i的数目为dp[i-1]*(k-1)
     * 则递推公式为：
     * dp[i] = dp[i-2]*(k-1) + dp[i-1]*(k-1)
     *
     * todo 简单动态规划
     * @param n 栅栏柱个数
     * @param k 颜色数
     * @return 方案数
     */
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] * (k - 1) + dp[i - 1] * (k - 1);
        }
        return dp[n - 1];
    }

}
