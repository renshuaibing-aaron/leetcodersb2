package com.aaron.ren.leetcode20201030;

public class LongestCommonSubs {

    //最长公共子串 怎么求
    public int longestCommonSubsequence(String text1, String text2) {
        //关键的几个地方
        //设置哨兵
        //序号从1开始
        //charat 是i-1啊
        char[] chars = text1.toCharArray();
        char[] chars1 = text2.toCharArray();

        int[][] res=new int[chars.length+1][chars1.length+1];
        for(int i=1;i<=chars.length;i++){
            for(int j=1;j<=chars1.length;j++){

                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    res[i][j]=res[i-1][j-1]+1;
                }
                if(text1.charAt(i-1)!=text2.charAt(j-1)){
                    res[i][j]=Math.max(res[i-1][j],res[i][j-1]);
                }

            }

        }

        return res[chars.length][chars1.length];

    }
}
