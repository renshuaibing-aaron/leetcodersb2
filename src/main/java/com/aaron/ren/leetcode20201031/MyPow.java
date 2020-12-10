package com.aaron.ren.leetcode20201031;

public class MyPow {

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
    }
    public static  double myPow(double x, int n) {
        if(n==0){
            return 1;
        }

        if(n>0){
            double res=x;
            for(int i=1;i<n;i++){
                x=res*x;
            }

            return  x;
        }else{
            double res=x;
            for(int i=1;i<-n;i++){
                x=res*x;
            }

            return  1/x;
        }



    }
}
