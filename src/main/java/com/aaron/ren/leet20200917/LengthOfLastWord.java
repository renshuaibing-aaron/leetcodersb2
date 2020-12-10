package com.aaron.ren.leet20200917;

import java.util.Arrays;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("    a a hell a "));
    }


    public static  int lengthOfLastWord(String s) {
        if (s.length()==0||s==null) {
            return 0;
        }
        //这个特码的进行分割不就行了
        String[] s1 = s.trim().split(" ");
        System.out.println(Arrays.toString(s1));
        return s1[s1.length-1].length();

    }
}
