package com.aaron.ren.leet20200909;

//最长的公共子序列
public class GetLCstring2 {


    // 求最长的公共子序列
    //妈的注意 公共子序列的原因啊
    public static int gaxSubsequence(String text1, String text2){
        int length = text1.length();
        int length1 = text2.length();
        int[][] res=new int[length+1][length1+1];

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                }else{
                    res[i][j]=Math.max(res[i - 1][j],res[i][j - 1]);
                }
            }
        }
        return res[length][length1];

    }
}
