package com.aaron.ren.leetcode20201101;

public class MaxValue {

    public static void main(String[] args) {

        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maxValue(grid));
    }

    //礼物的最大值
    //可以用动态规划
    public static  int maxValue(int[][] grid) {

        int[][]  res=new int[grid.length][grid[0].length];
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                System.out.println("i==="+i+"j=="+j);
                if(i==0&&j==0){
                    res[i][j]=grid[0][0];
                }
               else if(i==0&&j!=0){
                    res[i][j]=res[i][j-1]+grid[i][j];
                }
                else if(j==0&&i!=0){
                    res[i][j]=res[i-1][j]+grid[i][j];
                }else {
                    res[i][j]=Math.max(res[i-1][j],res[i][j-1])+grid[i][j];
                }

            }

        }

         return res[grid.length-1][grid[0].length-1];

    }
}
