package com.aaron.ren.zhuanxiang.testpermutepailie;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(permute(nums));

        int[] nums2={1,1,3};
        System.out.println(permute(nums2));

    }

    public static  List<List<Integer>> permute(int[] nums) {
        //没有重复数字的全排列

        List<List<Integer>>  res=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();

        boolean[] used=new boolean[nums.length];

        dfs(nums,path,res,used);

        return res;

    }

    private static void dfs(int[] nums, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {

        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]==false){
                if(i>0&&used[i-1]==false&&nums[i-1]==nums[i]){
                   continue;
                }
                path.addLast(nums[i]);
                used[i]=true;
                dfs(nums, path, res, used);
                path.removeLast();
                used[i]=false;
            }

        }
    }
}
