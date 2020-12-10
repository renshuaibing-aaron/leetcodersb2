package com.aaron.ren.leetcode20201101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abb")));
    }
    public static  String[] permutation(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        Arrays.sort(chars);

        List<String> result=new ArrayList<>();

        StringBuilder path=new StringBuilder();
        boolean[] used=new boolean[length];

        dfs(chars,length,0,result,path,used);

        //System.out.println(result);
        String[] strings = result.toArray(new String[result.size()]);
        return strings;
    }

    /**
     *
     * @param chars
     * @param length
     * @param dept
     * @param result
     * @param path
     * @param used
     */
    private static  void dfs(char[] chars, int length, int dept, List<String> result, StringBuilder path, boolean[] used) {
        if(length==dept){
            result.add(new String(path));
            return;
        }

        for(int i=0;i<length;i++){
            if(used[i]==false){
                //这里是什么意思
                if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i]=true;
                System.out.println("==加入=="+chars[i]+"==序号=="+i);
                path.append(chars[i]);
                dfs(chars,length,dept+1,result,path,used);
                System.out.println("==退出=="+path.charAt(path.length() - 1)+"==序号=="+i);
                path.deleteCharAt(path.length() - 1);
                used[i]=false;

            }

        }
    }
}
