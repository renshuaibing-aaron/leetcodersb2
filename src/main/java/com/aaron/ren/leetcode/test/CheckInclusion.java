package com.aaron.ren.leetcode.test;

import java.util.Arrays;

public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for(int i=0,j=chars1.length-1;j<chars1.length;i++,j++){
            int l=0;
           for(int k=i;k<=j;k++){
               if(chars2[k]==chars1[l]){
                 l++;
               }
           }
        }
    return false;
    }
}
