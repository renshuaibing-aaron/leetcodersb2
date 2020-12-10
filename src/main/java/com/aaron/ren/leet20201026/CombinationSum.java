package com.aaron.ren.leet20201026;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        int[] nums={2,3,6,7};
        List<List<Integer>> lists = combinationSum(nums, 7);
        System.out.println(lists);
    }

    public static  List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> res=new ArrayList<>();

        Deque<Integer>  path=new LinkedList<>();

        dfs(nums,target,res,path);
        return res;

    }

    //怎么去除重复的
    private static void dfs(int[] nums, int target, List<List<Integer>> res, Deque<Integer> path) {
       int sum=0;
        for(Integer item :path){
            sum=sum+item;
        }

        if(target==sum){
            res.add(new ArrayList<>(path));
            return;
        }
        if(sum>target){

            return;
        }
        for(int i=0;i<nums.length;i++){
            path.addLast(nums[i]);
            dfs(nums,target,res,path);
            path.removeLast();
        }

    }













    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs1(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs1(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意   妈的 这里 为什么从begin开始搜索呢
        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs1(candidates, i, len, target - candidates[i], path, res);
            // 状态重置
            path.removeLast();
        }
    }





}
