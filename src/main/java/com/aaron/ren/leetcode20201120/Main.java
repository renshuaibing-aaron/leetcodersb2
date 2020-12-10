package com.aaron.ren.leetcode20201120;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/20 20:33
 */

public class Main {

    public static void main(String[] args) {

         //最长无重复字符子串


    }
    public int subStr(String str){

        int res=1;

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(str.charAt(0));
        for(int i=1;i<str.length();i++){

            //abncdde
            char c = str.charAt(i);
            int index = stringBuilder.indexOf(String.valueOf(c));
            if(index<0){
                stringBuilder.append(c);
                res=Math.max(stringBuilder.length(),res);
            }else{
                stringBuilder.substring(index + 1,stringBuilder.length());

            }


        }

        return res;


    }

}
