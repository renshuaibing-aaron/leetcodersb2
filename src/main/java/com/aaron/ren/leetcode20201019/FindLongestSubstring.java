package com.aaron.ren.leetcode20201019;

import java.util.Scanner;

public class FindLongestSubstring {
    public static void main(String[] args) {



            String s1 = "wefefcvfw";
            String s2 = "dwqewdcdsvfvfw";
            String longestSubstring = findLongestSubstring(s1, s2);
            System.out.println(longestSubstring);

    }

    public static String findLongestSubstring(String s1, String s2) {
        //不同的三元表达式，是为了避免相同长度字符串的问题
        String max = s1.length() >= s2.length() ? s1 : s2;
        String min = s1.length() >= s2.length() ? s2 : s1;

        int longest = 0;//记录每次循环得到的最长子串长度
        String longestString = "";
        //这里使用短字符串，可降低时间复杂度
        for (int i = 0; i < min.length(); i++) {
            for (int j = i + 1; j <= min.length(); j++) {
                if (max.contains(min.substring(i, j)) && j - i > longest) {
                    longest = j - i;
                    longestString = min.substring(i, j);
                }
            }
        }
        return longestString;
    }
}
