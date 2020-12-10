package com.aaron.ren.leet20200920;

public class GcdOfStrings {

    //字符串的最大公因子
    public String gcdOfStrings(String str1, String str2) {
        if (str1 + str2 != str2 + str1) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }


    private  int gcd(int a,int b){
        return b == 0? a : gcd(b , a % b);
    }

}
