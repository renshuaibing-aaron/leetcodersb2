package com.aaron.ren.leet20200915;

import java.util.*;

public class Subsets {

    List<List<Integer>> res = new ArrayList<>();

    //nums = [1,2,3]
    //不重复的数字

    public List<List<Integer>> subsets(int[] nums) {
        Deque<Integer> path=new LinkedList<>();
        Arrays.sort(nums); // 排序 加快后续搜索
        backtrace(nums, path, 0);
        return res;
    }

    private void backtrace(int[] nums,  Deque<Integer> path, int start) {
        res.add(new ArrayList<>(path));
        // start 本轮搜索起始下标
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            backtrace(nums, path, i + 1); // 下一轮(i+1)不包含自身
            path.removeLast();
        }
    }
}
