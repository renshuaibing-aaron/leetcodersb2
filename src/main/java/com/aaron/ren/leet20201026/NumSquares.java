package com.aaron.ren.leet20201026;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NumSquares {

    public static void main(String[] args) {

        numSquares(12);
    }

    //完全平方数
    public static  int numSquares(int n) {

       Deque<Integer> path=new LinkedList<>();

        List<List<Integer>>  res=new ArrayList<>();
       dfs(n,path,res);

       int num=Integer.MAX_VALUE;
       for(List<Integer>  item :res){
           if(num>item.size()){
               num=item.size();
           }
       }
        System.out.println(res);
       return num;
    }

    private static void dfs(int n,Deque<Integer> path, List<List<Integer>> res ) {

        if(n==0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(n<0){
            return;
        }
        for(int i=n;i>=1;i--){
            if(checknumSquares(i)){
                path.addLast(i);
                dfs(n-i,path,res);
                path.removeLast();
            }

        }


    }

    /**
     * 判断是完全平方数
     * @param n
     * @return
     */
    private  static boolean checknumSquares(int n){

        int i=1;
        while(i<=n){
          if(i*i==n){
             return  true;
          }
          i++;

        }

        return false;

    }
}
