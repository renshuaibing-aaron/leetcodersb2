package com.aaron.ren.leetcode20201019;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    //二进制和相加
    //11  1   --100
    public static  String addBinary(String a, String b) {

        char[] charsa = new StringBuilder(a).reverse().toString().toCharArray();
        char[] charsb = new StringBuilder(b).reverse().toString().toCharArray();

        int jinwei=0;
        int i=0;
        int j=0;

        int max = Math.max(charsa.length, charsb.length);
        StringBuilder stringBuilder = new StringBuilder();
        while(i<max){
            int a1,b1;
            if(i<charsa.length){
                a1= charsa[i]-'0';
            }else{
                a1=0;
            }

            if(i<charsb.length){
                 b1 = charsb[i]-'0';
            }else{
                b1=0;
            }

            int i1 = a1 + b1 + jinwei;
                int i2 = i1 % 2;
                int i3 = i1 / 2;
               System.out.println(i2);
                stringBuilder.append(i2);
                jinwei=i3;

             i++;

        }

        if(jinwei==1){
            System.out.println("1");
            stringBuilder.append("1");
        }

        return stringBuilder.reverse().toString();

    }
}
