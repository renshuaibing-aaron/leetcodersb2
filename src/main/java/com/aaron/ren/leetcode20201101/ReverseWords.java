package com.aaron.ren.leetcode20201101;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWords {

    public static void main(String[] args) {
        String str="a good      example";
        System.out.println(reverseWords2(str));
    }

    public static  String reverseWords2(String nums) {
        String[] words = nums.trim().split(" +");

        System.out.println(Arrays.toString(words));

        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
    //反转单词顺序
    public static String reverseWords(String s) {

        String trim = s.trim();
        String[] s1 = trim.split(" ");

        int i=0; int j=s1.length-1;

        while(i<j){
            String tmp=s1[i];
            s1[i]=s1[j];
            s1[j]=tmp;
            i++;
            j--;
        }

        return  Arrays.toString(s1);

    }
}
