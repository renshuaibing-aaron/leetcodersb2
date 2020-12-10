package com.aaron.ren.zhuanxiang.testpermutepailie;

import java.util.*;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/22 21:41
 */

//无重复元素的子集
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Deque<Integer> path=new LinkedList<>();
        dfs(res, path, nums, 0); //从含有0个元素的情况开始分析
        return res;

    }

    public static void dfs(List<List<Integer>> res,  Deque<Integer> path, int[] nums, int start) {
        res.add(new LinkedList<Integer>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            dfs(res, path, nums, i + 1);
            path.removeLast();

        }
    }
}
