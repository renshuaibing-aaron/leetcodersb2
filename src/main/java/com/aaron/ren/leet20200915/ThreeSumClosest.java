package com.aaron.ren.leet20200915;

import java.util.Arrays;

public class ThreeSumClosest {
    //最接近的三数之和
    //用普通的方法  的时间复杂度是0n3
    //采用排序+双指针的形式
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;

                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }

            }

        }

        return ans;

    }
}
