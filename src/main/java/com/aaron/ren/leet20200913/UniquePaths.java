package com.aaron.ren.leet20200913;

public class UniquePaths {

    //不同路径 明显用动态规划啊
    public int uniquePaths(int m, int n) {
        //动态规划入门 设置一个二维数组 用来保存从开始到结束的值
        //dp[i][j]=dp[i-1][j]+dp[i][j-1]   这里是问题路径数  不是路径的值 注意区别
        //另外二维数组 i 表示行  j表示 列

        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    res[i][j]=1;
                }else{
                    res[i][j]=res[i-1][j]+res[i][j-1];
                }
            }
        }
        return res[m-1][n-1];

    }
}
