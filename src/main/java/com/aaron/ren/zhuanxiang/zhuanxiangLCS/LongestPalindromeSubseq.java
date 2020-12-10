package com.aaron.ren.zhuanxiang.zhuanxiangLCS;

//最长回文子序列
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        if(s.length()<1){
            return 0;
        }
        int length = s.length();
        int[][] dp=new int[length][length];

        //注意这个和最长回文子串进行对比  这里都是减少1
        for(int i=length-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<length;j++){
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j]= dp[i+1][j-1]+2;
                } else {
                    dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][length-1];
    }
}
