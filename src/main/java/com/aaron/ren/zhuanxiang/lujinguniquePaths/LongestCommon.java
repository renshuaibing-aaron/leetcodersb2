package com.aaron.ren.zhuanxiang.lujinguniquePaths;


//最长公共子串
public class LongestCommon {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int length1 = chars1.length;
        int length2 = chars2.length;

        int[][] dp=new int[length1+1][length2+1];
        //注意 dp[i][j] 表示的是str1 0-i  和str2 0-j 的最长公共子序列
int res=0;
        for(int i=1;i<length1+1;i++){
            for(int j=1;j<length2+1;j++){
                if(chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;

                }else{
                    dp[i][j]=0;
                }
                res=Math.max(dp[i][j],res);

            }
        }
        return res;

    }
}
