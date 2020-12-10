package com.aaron.ren.leet20200919;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanPermutePalindrome {


    //能否形成回文排列
    public boolean canPermutePalindrome(String s) {
        //判断能否形成回文串
        //很简单 根据回文串的特点只要 超过一个字符出现奇数次 就不行
        char[] chars = s.toCharArray();
      Map<Character,Integer> map=new HashMap<>();

       for(int i=0;i<s.length();i++){
           map.put(chars[i],map.getOrDefault(chars[i],0)+1);
       }
       int count=0;
       for(char key:map.keySet()){
           count += map.get(key) % 2;

       }

       return count<=1;


    }
}
