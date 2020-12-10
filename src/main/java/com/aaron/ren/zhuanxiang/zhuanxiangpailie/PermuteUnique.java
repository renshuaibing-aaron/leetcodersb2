package com.aaron.ren.zhuanxiang.zhuanxiangpailie;

import java.util.*;

public class PermuteUnique {
    public static void main(String[] args) {
        int[] nums={1,1,3};
        System.out.println(permuteUnique(nums));
    }

    //怎么去重
    public static List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();

        Deque<Integer> path =new LinkedList<>();

        boolean[] used=new boolean[nums.length];
        dfs(nums,res,path,used);
        return res;

    }

    //关键是怎么去重 1 1  3    1 1 3
    private static void dfs(int[] nums, List<List<Integer>> res, Deque<Integer> path,boolean[] used) {
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
        }

        for(int i=0;i<nums.length;i++){

            // 怎么来去重
            // 怎么进行去重
            if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false){
                continue;
            }
            if(!used[i]){
                used[i]=true;
                path.addLast(nums[i]);
                dfs(nums, res, path, used);
                used[i]=false;
                path.removeLast();


            }

        }

    }
}
