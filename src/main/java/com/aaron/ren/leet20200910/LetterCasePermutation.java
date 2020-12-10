package com.aaron.ren.leet20200910;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static void main(String[] args) {
        List<String> res = letterCasePermutation("ab");

        System.out.println(res);
    }

    //S = "a1b2"  ["a1b2", "a1B2", "A1b2", "A1B2"]
    public  static  List<String> letterCasePermutation(String str) {

        List<String>  res=new ArrayList<>();
        dfs(res,str.toCharArray(),0);
        return  res;

    }

    private static void dfs(List<String> res, char[] toCharArray, int index) {

        if(index==toCharArray.length){
            res.add(new String(toCharArray));
            return;
        }
        dfs(res,toCharArray,index+1);
       if(toCharArray[index]>='A'){
           toCharArray[index] = toCharArray[index] < 'a'? (char)(toCharArray[index] + 32): (char)(toCharArray[index] - 32);
           dfs(res,toCharArray, index + 1);


       }
    }
}
