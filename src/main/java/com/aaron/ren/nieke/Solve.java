package com.aaron.ren.nieke;

public class Solve {

    public static void main(String[] args) {
        char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        System.out.println( solve(grid));;
    }
    /**
     * 判断岛屿数量 numIslands solve
     * @param grid char字符型二维数组
     * @return int整型
     */
    public static  int solve (char[][] grid) {
        // write code here
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    inset(i,j,grid,res);

                }

            }
        }

        return res;
    }

    private  static void inset(int i,int j,char[][] grid,int res){

        //注意这个范围
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]!='1'){
            return;
        }
        if(grid[i][j]=='1'){

            //这里明显应该这样写 原因 否则会出现栈溢出
            grid[i][j]='2';
            inset(i+1,j,grid,res);
            inset(i,j+1,grid,res);
            inset(i-1,j,grid,res);
            inset(i,j-1,grid,res);
        }


    }
}
