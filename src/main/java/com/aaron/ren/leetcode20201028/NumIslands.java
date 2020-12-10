package com.aaron.ren.leetcode20201028;

public class NumIslands {

    public static void main(String[] args) {

        int [] a={1,2,3};
        char[][] grid={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    System.out.println(grid[i][j]);
                }

        }
        int i = numIslands(grid);
        System.out.println(i);
    }
    public static  int numIslands(char[][] grid) {

        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res=res+1;
                    inset(grid,i,j);
                }
            }

        }

return res;
    }

    private static void inset(char[][] grid, int i, int j) {
           if(i>=grid.length||i<0||j>=grid[0].length||j<0 ||grid[i][j]!='1'){
               return;
           }
grid[i][j]='2';
inset(grid, i+1, j);
inset(grid, i, j+1);
inset(grid, i-1, j);
inset(grid, i, j-1);
    }
}
