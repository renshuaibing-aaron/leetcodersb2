package com.aaron.ren.zhuanxiang.testpermutepailie;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/22 21:42
 */

public class SubsetsWithDup {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path=new LinkedList<>();
        Arrays.sort(nums);
        dfs(res, path, nums, 0); //从含有0个元素的情况开始分析
        return res;

    }

    public static void dfs(List<List<Integer>> res,  Deque<Integer> path, int[] nums, int start) {
        res.add(new LinkedList<Integer>(path));
        for (int i = start; i < nums.length; i++) {

            //这里要搞清楚 为什么这么写就可以去重呢 牛逼
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            dfs(res, path, nums, i + 1);
            path.removeLast();

        }
    }
}
