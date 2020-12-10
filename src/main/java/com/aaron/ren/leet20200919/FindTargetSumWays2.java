package com.aaron.ren.leet20200919;

public class FindTargetSumWays2 {

    public int findTargetSumWays(int[] nums, int S) {

        return dfs(nums, S, 0);
    }

    //先简单的用dfs 进行实现
    private int dfs(int[] nums, int target, int left) {
        if (target == 0 && left == nums.length) {
            return 1;
        }
        if (left >= nums.length) {
            return 0;
        }
        int ans = 0;
        ans = ans + dfs(nums, target - nums[left], left + 1);
        ans = ans + dfs(nums, target + nums[left], left + 1);
        return ans;
    }

}
