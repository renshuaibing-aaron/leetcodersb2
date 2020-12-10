package com.aaron.ren.leetcode20201101;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        permutation("aac");
    }
    //关键是不能有重复元素
    public static  String[] permutation(String s) {

        List<String> res=new ArrayList<>();
        Deque<Character> path=new LinkedList<>();

        boolean[] isused=new boolean[s.length()];

        dfs(res,s,path,isused);

        System.out.println(res);
        return  null;

    }

    private static  void dfs(List<String> res, String s, Deque<Character> path, boolean[] isused) {
        if(path.size()==s.length()){
            res.add(path.toString());
        }
        for(int i=0;i<s.length();i++){
            if(!isused[i]){
                path.addLast(s.charAt(i));
                isused[i]=true;
                dfs(res,s,path,isused);
                isused[i]=false;
                path.removeLast();
            }

        }
    }
}
