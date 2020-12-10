package com.aaron.ren.leet20200914;

//https://mp.weixin.qq.com/s/XJyujBI5nofVE9CUbStemA
public class FindLength {

    //最长子数组
       /* A: [1,2,3,2,1]
        B: [3,2,1,4,7]*/

    public int findLength(int[] A, int[] B) {

        //本题一个简单的解答是用动态规划实现
        //使用一个二维数组dp[i][j]  表示的意思是 第一个数组第i个位置和第二个数组第j个位置
        // 的最大公共子串的长度
        //dp[i][j]=dp[i-1][j-1]+1  或者=0

        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return 0;
        }
        int max = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 1; i <= A.length; i++) {  //注意这里i是从1开始取值 并且注意边界是
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);

            }

        }
        return max;
    }
}
