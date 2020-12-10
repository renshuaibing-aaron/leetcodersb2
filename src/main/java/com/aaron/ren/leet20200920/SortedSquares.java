package com.aaron.ren.leet20200920;

import java.util.Arrays;

public class SortedSquares {

    public static void main(String[] args) {

        int abs = Math.abs(0);
        int abs2 = Math.abs(-1);

        System.out.println(abs>abs2);
    }
    public int[] sortedSquares(int[] A) {
        int[] res=new int[A.length];
        for(int i=0;i<A.length;i++){
            res[i]=A[i]*A[i];
        }

        Arrays.sort(res);
        return res;

    }

    public int[] sortedSquares2(int[] A) {
        int[] res=new int[A.length];

        int p=0,q=A.length-1,index=A.length-1;

        while(p<=q){

            if(Math.abs(A[p])>Math.abs(q)){
                res[index]=A[p]*A[p];
                p++;
            }else{
                res[index]=A[q]*A[q];
                q--;
            }

            index--;
        }

        return res;

    }
}
