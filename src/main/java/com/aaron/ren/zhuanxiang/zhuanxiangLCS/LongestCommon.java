package com.aaron.ren.zhuanxiang.zhuanxiangLCS;


//最长公共子串
public class LongestCommon {
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

    public static void main(String[] args) {
        System.out.println(LCS("CABC", "ABD"));
    }

    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static  String LCS (String str1, String str2) {
        //公共子串
        //dp[i][j]=dp[i-1][j-1]+1
        //最大值会变化
        if(str1.length()<1||str2.length()<1){
            return null;
        }
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        int res=0;
        int right1=0;
        int right2=0;
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=0;
                }
                if(dp[i][j]>res){
                    right1=i;
                    right2=j;
                    res=dp[i][j];
                }

            }
        }
        System.out.println(right1);
        System.out.println(res);
        return str1.substring(right1-res,right1);

    }


}
