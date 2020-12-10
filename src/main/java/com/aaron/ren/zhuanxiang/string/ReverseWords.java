package com.aaron.ren.zhuanxiang.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/22 12:08
 */

public class ReverseWords {


    //注意这里用正则表达式
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");

        //  System.out.println(Arrays.toString(words));

        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
   /* 输入: "the sky is blue"
    输出: "blue is sky the"*/
    public String reverseWords2(String s) {

        String[] s1 = s.split(" ");
        List<String> list=new ArrayList<>();
        for(String str:s1){
            list.add(str);
        }
        Collections.reverse(list);
        String[] strings = list.toArray(new String[list.size()]);
        return  strings.toString();

    }
}
