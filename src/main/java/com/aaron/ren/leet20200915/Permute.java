package com.aaron.ren.leet20200915;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute {

    //没有重复数字的全排列
    public static  List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res=new ArrayList<>();

        if(length==0){
            return res;
        }
        boolean[] isflag=new boolean[nums.length];

        Deque queue=new ArrayDeque(nums.length);
        dfs(res,nums,isflag,queue);
        return res;

    }

    private static void dfs(List<List<Integer>> res, int[] nums, boolean[] isflag, Deque queue) {
        if(queue.size()==nums.length){
            // res.add(tmp);  这里不行
            res.add(new ArrayList<Integer>(queue));  //
        }
        for(int i=0;i<nums.length;i++){

            if(isflag[i]==false){
                isflag[i]=true;
                queue.addLast(nums[i]);
                dfs(res,nums,isflag,queue);
                //怎么回退
                queue.removeLast();
                isflag[i]=false;
            }

        }
    }
}
