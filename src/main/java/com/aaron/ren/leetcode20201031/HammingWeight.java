package com.aaron.ren.leetcode20201031;

public class HammingWeight {

    public static void main(String[] args) {
        System.out.println(hammingWeight(4294967293L));
    }
    // you need to treat n as an unsigned value
    public static  int hammingWeight(Long n) {

        int res=0;
        StringBuffer  sb=new StringBuffer();

        while(n!=0){
            Long i = n % 2;
            if(i==1){
                res++  ;
            }
             n= n/2;
           sb.append(i);
        }

        return res;

    }
}
