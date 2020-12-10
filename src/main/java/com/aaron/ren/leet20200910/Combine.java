package com.aaron.ren.leet20200910;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combine {

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);

        System.out.println(combine);

    }

    //1-n  k个数
    public static  List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        int[] array=new int[n];
        for(int i=0;i<array.length;i++){
            array[i]=i+1;
        }
        boolean[] used=new boolean[n];
        Deque<Integer>  dequeue=new LinkedList<>();

        dfs(array,dequeue,res,used,k);
        return res;
    }

    private static void dfs(int[] array, Deque<Integer> dequeue, List<List<Integer>> res, boolean[] used,int count) {
        if(dequeue.size()==count){
            res.add(new ArrayList<>(dequeue));
            return;
        }

        for(int i=0;i<array.length;i++){
            if(used[i]==false){
                dequeue.addLast(array[i]);
                used[i]=true;
                dfs(array,dequeue,res,used,count);
                dequeue.removeLast();
                used[i]=false;
            }


        }

    }
}
