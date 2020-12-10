package com.aaron.ren.leetcode20201102;

public class IsPalindrome {

    //这个和昨天那个 判断数字是不是回文 是不是相同的思路
    public int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }
    //检测是不是回文数
    //143  -- 14  --3
    //判断回文数的数学方法
    public boolean isPalindrome(int x) {
       if(x<0){
           return false;
       }
       int tmp=x;
       int resernum=0;
       while(tmp>0){
           int i = tmp % 10;
           tmp = tmp / 10;

           resernum=i+resernum*10;
       }
       return resernum==x;
    }

    public boolean isPalindrome2(int num) {
        if (num < 0) {
            return false;
        }
        int numtmp = num;
        int resernum = 0;
        while (numtmp > 0) {
            int i = numtmp % 10;  //
            numtmp = numtmp / 10;  //剩余的数
            resernum = i + resernum * 10;
        }
        System.out.println(resernum);
        return resernum == num;
    }
}
