package com.aaron.ren.leet20200919;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindLongestWord {

    public static void main(String[] args) {
        findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea","aaple"));
    }

    //通过删除字母 获取字典里面最长的单词
    public static String findLongestWord(String s, List<String> d) {

        //先对字典里面的字符串进行排序
        List<String> collect = d.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()!=o2.length()? o2.length() - o1.length():o1.compareTo(o2);
            }
        }).collect(Collectors.toList());

        //采用流的方式正确排序即可
        System.out.println(collect);

       for(String  str :collect){
          if( chackContains(s,str)){
              return str;
          };
       }
        //查看s中是不是可以包含
        return "";

    }

    private static boolean chackContains(String s, String str) {
        int p=0,q=0;

        while(p<s.length()&&q<str.length()){

            if(s.charAt(p)==str.charAt(q)){
                p++;
                q++;
            }else{
               p++;
            }

        }

        return q==str.length();
    }

}
