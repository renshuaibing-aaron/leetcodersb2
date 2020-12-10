package com.aaron.ren.leet20200912;

public class LongestCommonPrefix {


   /* 输入: ["flower","flow","flight"]
    输出: "fl*/
    public String longestCommonPrefix(String[] strs) {
        //字符串数组的最长公共前缀
        if(strs == null || strs.length == 0) return "";
        String res = strs[0];
        for (String str : strs) {
            //表示必须从0开始包含
            while (str.indexOf(res) != 0) {
                //开始滑动
                res = res.substring(0, res.length()-1);
            }
        }
        return res;


    }
}
