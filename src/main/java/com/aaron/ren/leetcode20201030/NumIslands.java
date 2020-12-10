package com.aaron.ren.leetcode20201030;

public class NumIslands {
    public static void main(String[] args) {
        char[][] grid ={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

    //连通域数量
    public static  int numIslands(char[][] grid) {

        int res=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    inset(i,j,grid);
                }
            }

        }

        return res;

    }

    private static void inset(int i, int j, char[][] grid) {
  /*      if(i>=grid.length||i<0||j>=grid[0].length||j<0 ||grid[i][j]!='1'){
            return;
        }
        grid[i][j]='2';
        inset(grid, i+1, j);
        inset(grid, i, j+1);
        inset(grid, i-1, j);
        inset(grid, i, j-1);*/
        }
}
