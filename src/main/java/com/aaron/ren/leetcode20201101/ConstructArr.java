package com.aaron.ren.leetcode20201101;

public class ConstructArr {

    //构建乘积数组
    public int[] constructArr(int[] a) {

        int[] res=new int[a.length];
        int tmp=1;
        for(int i=0;i<a.length;i++){
            tmp=tmp*a[i];
        }

        for(int i=0;i<a.length;i++){
            if(true){

            }
            res[i]=tmp/a[i];
        }

        return res;

    }
}
