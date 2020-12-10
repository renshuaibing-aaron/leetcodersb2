package com.aaron.ren.leetcode20201031;

public class MovingCount {

    public static void main(String[] args) {
        System.out.println(movingCount(14, 14, 5));
    }
    public static  int movingCount(int m, int n, int k) {
        int[][]  grid=new int[m][n];
        int res=0;
                inset(grid,0,0,res,k);

        return res;

    }

    //总感觉 一些地方有问题
    private static void inset(int[][] grid, int i, int j, int res,int k) {
        System.out.println(i+"---"+j+"---"+res);
        if(i<0||i>grid.length-1||j<0||j>grid[0].length){
            return;
        }

        if(grid[i][j]==0&&(get(i)+get(j))<=k){
            res=res+1;
            grid[i][j]=1;
        }
        inset(grid, i+1, j, res, k);
        inset(grid, i, j+1, res, k);
    }


    private static int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

}
