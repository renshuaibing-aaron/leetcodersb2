package com.aaron.ren.zhuanxiang.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/22 12:13
 */

public class ReverseWords2 {

    //输入："Let's take LeetCode contest"
    //输出："s'teL ekat edoCteeL tsetnoc"
    public String reverseWords(String s) {
        StringBuilder stringBuilder=new StringBuilder(s);
        String string = stringBuilder.reverse().toString();
        String[] split = string.trim().split(" +");
        List<String> strings = Arrays.asList(split);

        Collections.reverse(strings);

        return String.join(" ", strings);



    }
}
