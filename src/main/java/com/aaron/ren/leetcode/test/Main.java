package com.aaron.ren.leetcode.test;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 7, 1,3,5};
        System.out.println(permutation("abc"));

    }
    public boolean checkInclusion(String s1, String s2) {
        String[] permutation = permutation(s1);

        for(String str:permutation){
            if(s2.contains(str)){
                return true;
            }
        }
        return false;
    }

    //求第n个丑数
    //我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
    public static  String[] permutation(String s) {

        char[] chars = s.toCharArray();
        int length = chars.length;
        Arrays.sort(chars);

        List<String> result=new ArrayList<>();

        StringBuilder path=new StringBuilder();
        boolean[] used=new boolean[length];

        dfs(chars,length,0,result,path,used);

       // System.out.println(result);
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

                used[i]=true;
                path.append(chars[i]);
                dfs(chars,length,dept+1,result,path,used);
                path.deleteCharAt(path.length() - 1);
                 used[i]=false;

            }

        }
    }
}
