package com.aaron.ren.leet20200912;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {


    //输入: ["t" , "h" , "e" , " " ,"s","k","y"," ","i","s"," ","b","l","u","e"]
    //输出: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
    public void reverseWords(char[] s) {

        //单词反转
        //这个尼玛
        String str = new String(s);
        String[] strArry = str.split(" ");
        List<String> stringList = Arrays.asList(strArry);
        Collections.reverse(stringList);
        //blue is sky the
        //转化为字节数组
        String join = String.join(" ", stringList);
        System.out.println(join);
        s=  join.toCharArray();

    }
}
