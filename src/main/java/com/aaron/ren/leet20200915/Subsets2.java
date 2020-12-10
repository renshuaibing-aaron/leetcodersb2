package com.aaron.ren.leet20200915;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path=new LinkedList<>();
        dfs(res, path, nums, 0); //从含有0个元素的情况开始分析
        return res;

    }

    public static void dfs(List<List<Integer>> res,  Deque<Integer> path, int[] nums, int start) {
        res.add(new LinkedList<Integer>(path));

        //这个不用剪枝啊
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(res, path, nums, i + 1);
            path.removeLast();

        }
    }
}
