package com.aaron.ren.zhuanxiang.qury;

public class SearchMatrix {

    //矩阵的查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int xlength = matrix.length;

        if (xlength == 0) {
            return false;
        }

        int ylength = matrix[0].length;
        int x = 0;
        int y = ylength - 1;
        while (x < xlength && y >= 0) {
            if (target < matrix[x][y]) {
                y--;
            } else if (target > matrix[x][y]) {
                x++;
            } else {
                return true;
            }
        }

        return false;
    }
}
