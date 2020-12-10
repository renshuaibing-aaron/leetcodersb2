package com.aaron.ren.leet20200912;

import java.util.Collections;
import java.util.HashMap;

public class LengthOfLongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringTwoDistinct2(String s) {

        //利用滑动窗口即可
 /*       char[] chars = s.toCharArray();

        int res=0;
        String  windows=null;
        for(int i=0;i<s.length();i++){
            windows=windows+s.indexOf(0);
            //判断是否合法
            if(true){
                res=Math.max(res,windows.length());

            }else{
                //整理滑动窗口
                windows=;
                res=Math.max(res,windows.length());
            }

        }*/

        return 0;

    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) return n;

        // sliding window left and right pointers
        int left = 0;
        int right = 0;
        // hashmap character -> its rightmost position
        // in the sliding window
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

        int max_len = 2;

        while (right < n) {
            // slidewindow contains less than 3 characters
            if (hashmap.size() < 3)
                hashmap.put(s.charAt(right), right++);

            // slidewindow contains 3 characters
            if (hashmap.size() == 3) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }

}
