package com.aaron.ren.leet20200913;

public class LongestPalindrome {


    //构造的最长回文字符串
    public int longestPalindrome(String s) {

     //构造利用这个字符串的最长回文字符串
        //a a s s d d

        char[] charsarray=new char[128];
        char[] chars = s.toCharArray();
        for(char charitem:chars){
            charsarray[charitem]++;
        }

        int ans=0;
        for(char charitem :charsarray){
            ans=charitem/2*2+ans;
            if(charitem%2==1&&ans%2==0){
                ans++;
            }
        }
        return  ans;

    }
}
