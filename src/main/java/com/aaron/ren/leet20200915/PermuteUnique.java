package com.aaron.ren.leet20200915;

import java.util.*;

public class PermuteUnique {
    //输入: [1,1,2]
    //返回所有不重复的全排列
    //返回重复的全排列怎么实现
    public List<List<Integer>> permuteUnique(int[] nums) {

        //用DFS实现
        List<List<Integer>> res=new ArrayList<>();
        Set<List<Integer>> set=new HashSet<>();

        Deque<Integer>  path=new LinkedList<>();
        boolean [] used=new boolean[nums.length];

        dfs(res,path,used,nums,set);
        return res;

    }
    //所以关键是怎么去重啊
    // 这里采用的是 暴力去重 ！！！！！！！
    private void dfs(List<List<Integer>> res, Deque<Integer> path, boolean[] used,int[] nums, Set<List<Integer>> set) {
        if(path.size()==nums.length){
            if(!set.contains(new ArrayList<>(path))){
                set.add(new ArrayList<>(path));
                res.add(new ArrayList<>(path));
            }

        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==false){
                path.addLast(nums[i]);
                used[i]=true;
                dfs(res,path,used,nums,set);
                path.removeLast();
                used[i]=false;
            }

        }
    }
}
