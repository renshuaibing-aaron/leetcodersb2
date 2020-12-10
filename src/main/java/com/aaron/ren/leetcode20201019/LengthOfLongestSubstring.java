package com.aaron.ren.leetcode20201019;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str="abcabcbb";
        System.out.println(str.substring(0,2    ));
        System.out.println(lengthOfLongestSubstring(str));
    }

    //最长不重复 子序列
    public static int lengthOfLongestSubstring(String s) {

        if(s.length()<=1){
            return s.length();
        }

        int res=1;
        //利用滑动窗口  初始化滑动窗口
        //
        String windows=s.substring(0,1);
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);

            if(!windows.contains(String.valueOf(c))){
                windows=windows+String.valueOf(c);

           }else{
                int index = windows.indexOf(String.valueOf(c));
                //切记 这个地方的情况 是index+1
                windows=windows.substring(index+1)+String.valueOf(c);
            }

            res=Math.max(res,windows.length());
        }


        return res;
    }





















    //"abcabcbb"
    public int lengthOfLongestSubstring2(String s) {
        //设置一个数组 表是

        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        //利用滑动窗口
        char[] chars=s.toCharArray();

        int result=0;

        String str=String.valueOf(chars[0]);
        for(int i=1;i<chars.length;i++){
            if(str==null||(!str.contains(String.valueOf(chars[i])))){
                str=str+String.valueOf(chars[i]);
            }
            else{
                int index = str.indexOf(chars[i]);
                //寻找第一次出现的字符
                str=str+String.valueOf(chars[i]);
                str=str.substring(index+1);
                //删除之前的字符
            }
            //   System.out.println(str);
            result=Math.max(result,str.length());
        }
        return result;

    }
}
