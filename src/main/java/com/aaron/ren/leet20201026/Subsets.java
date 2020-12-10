package com.aaron.ren.leet20201026;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        subsets(nums);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path=new LinkedList<>();
        dfs(res, path, nums, 0); //从含有0个元素的情况开始分析
        return res;

    }




    public static void dfs2(List<List<Integer>> res,  Deque<Integer> path, int[] nums, int start) {
        System.out.println("==+++==="+new LinkedList<Integer>(path));
        res.add(new LinkedList<Integer>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs2(res, path, nums, i + 1);
            path.removeLast();

        }
    }
    public static void dfs(List<List<Integer>> res,  Deque<Integer> path, int[] nums, int start) {
        if(start==nums.length){
            System.out.println("==+++==="+new LinkedList<Integer>(path));
            res.add(new ArrayList<>(path));
            return;
        }
        path.addLast(nums[start]);
        dfs(res,path,nums,start+1);
        path.removeLast();
        dfs(res,path,nums,start+1);
    }








}
