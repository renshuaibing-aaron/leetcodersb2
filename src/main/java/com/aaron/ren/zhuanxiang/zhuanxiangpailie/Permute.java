package com.aaron.ren.zhuanxiang.zhuanxiangpailie;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(permute(nums));
    }

    //1  23  4
    public static  List<List<Integer>> permute(int[] nums) {
        //没有重复数字的全排列
        List<List<Integer>> res=new ArrayList<>();

        Deque<Integer>  path=new LinkedList<>();

        boolean[] used=new boolean[nums.length];
        dfs(res,nums,used,path);
        return res;

    }

    private static void dfs(List<List<Integer>> res, int[] nums, boolean[] used, Deque<Integer> path) {

        if(path.size()==nums.length){
            res.add(new ArrayList<>(path) );
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                used[i]=true;
                path.addLast(nums[i]);
                dfs(res, nums, used, path);
                path.removeLast();
                used[i]=false;
            }
        }

    }
}
