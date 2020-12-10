package com.aaron.ren.zhuanxiang.zhuanxiangLCS;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] str={"aflower","flow","flight"};
        System.out.println(longestCommonPrefix(str));

        String string="a";
        String substring = string.substring(0, string.length() - 1);

        System.out.println(substring);
    }


    //求字符串数组的 最长公共前缀
    //这个方法可以可以进行优化
    //先考虑一般情况  在进行边界处理
    public static  String longestCommonPrefix(String[] strs) {



        int length = strs.length;
        if(strs == null || strs.length == 0) {
            return "";
        }
        String tmp=strs[0];

        //
        for(int i=1;i<length;i++){
            String str = strs[i];
            int index = str.indexOf(tmp);
            while(index!=0){
                tmp=tmp.substring(0,tmp.length()-1);
                index = str.indexOf(tmp);
            }

        }
        return tmp;

    }
}
