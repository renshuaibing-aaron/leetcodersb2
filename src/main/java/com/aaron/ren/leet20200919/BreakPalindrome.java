package com.aaron.ren.leet20200919;

import java.util.Arrays;

public class BreakPalindrome {


    //
    public String breakPalindrome(String palindrome) {
        //找到第一个不是a的字符串即可
        if(palindrome.length()<=1){
            return "";
        }

        if(palindrome.length()==3){
           if(palindrome.charAt(0)=='a'){
               //修改最后一个
               String substring = palindrome.substring(0, 2);
               String s = substring + 'b';
               return s;
           }else{
               //修改第一个
               String substring = palindrome.substring(1, palindrome.length());
               int i = palindrome.charAt(0) + 1;
               char c = (char) i;
               String s = c + substring;
            return  s;

           }
        }
        char[] chars = palindrome.toCharArray();
        int i=0;
        for( i=0;i<chars.length;i++ ){
            if(chars[i]!='a'){
                chars[i]='a';
                break;
            }
        }
        if(i==chars.length){
            chars[chars.length-1]='b';
        }

        return new String(chars);

    }
}
