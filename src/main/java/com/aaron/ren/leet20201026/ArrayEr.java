package com.aaron.ren.leet20201026;

public class ArrayEr {

    public static void main(String[] args) {
        int[][]   array ={{1,2,3},{4, 6}};

        //二维数组的运用
        System.out.println(array.length);
        System.out.println(array[0].length);

        for(int i=0;i<array.length;i++){
            int[] ints = array[i];
            for(int j=0;j<ints.length;j++){
                System.out.println(array[i][j]);
            }
        }
    }
}
