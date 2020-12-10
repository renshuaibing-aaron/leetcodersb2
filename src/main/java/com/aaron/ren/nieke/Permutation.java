package com.aaron.ren.nieke;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {

    public static void main(String[] args) {
        System.out.println(Permutation("ab"));
    }
    public  static  ArrayList<String> Permutation(String str) {
        //借用 上面的思想
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        StringBuffer path=new StringBuffer();
        ArrayList<String> res=new ArrayList<>();
        boolean[]  used=new boolean[str.length()];
        dfs(chars,path,res,used);
        return res;

    }

    //其实这个题 可以用最简单的来写
    private static  void dfs(char[] chars,StringBuffer path,ArrayList<String> res,boolean[]  used){
        if(path.length()==chars.length){
            res.add(path.toString());
           return;
        }
        for(int i=0;i<chars.length;i++){
          if(used[i]==false){

              if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                  return;
              }

              path.append(chars[i]);
              used[i]=true;
              dfs(chars, path, res, used);
              used[i]=false;
              path.deleteCharAt(path.length()-1);

          }

        }

    }
}
