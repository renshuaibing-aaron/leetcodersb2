package com.aaron.ren.zhuanxiang.xuanzhaunshuzi;

import java.util.ArrayList;
import java.util.List;

public class ReverseLeftWords {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdef", 1));  //bcdefa
        System.out.println(reverseLeftWords("abcdef", 2));
        System.out.println(reverseLeftWords("abcdef", 3));
        System.out.println(reverseLeftWords("abcdef", 4));
        System.out.println(reverseLeftWords("abcdef", 5));
        System.out.println(reverseLeftWords("abcdef", 6));
        System.out.println(reverseLeftWords("abcdef", 7));

        System.out.println("============");
        System.out.println(reverseRightWords("abcdef", 1));  //fabcde
        System.out.println(reverseRightWords("abcdef", 2));
        System.out.println(reverseRightWords("abcdef", 3));
        System.out.println(reverseRightWords("abcdef", 4));
        System.out.println(reverseRightWords("abcdef", 5));
        System.out.println(reverseRightWords("abcdef", 6));
        System.out.println(reverseRightWords("abcdef", 7));
    }

    public static  String reverseLeftWords(String s, int n) {
        int realstep = n % s.length();
        StringBuilder res = new StringBuilder();
        for(int i = realstep; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < realstep; i++)
            res.append(s.charAt(i));
        return res.toString();
    }
    public static  String reverseRightWords(String s, int n) {
        int num = n % s.length();
        StringBuilder res = new StringBuilder();
        int realstep = s.length() - num;
        for(int i = realstep; i < s.length(); i++)
            res.append(s.charAt(i));
        for(int i = 0; i < realstep; i++)
            res.append(s.charAt(i));
        return res.toString();
    }

    public int[] solve (int n, int m, int[] a) {
        // write code here
        int num=m%n;
        int[]res=new int[n];
        int j=0;
        int realnum=n-num;
        for(int i=realnum;i<n;i++){
            res[j]=a[i];
            j++;
        }
        for(int i=0;i<realnum;i++){
            res[j]=a[i];
            j++;
        }
        return  res;

    }

}
