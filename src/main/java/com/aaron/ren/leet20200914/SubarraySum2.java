package com.aaron.ren.leet20200914;

import java.util.*;

public class SubarraySum2 {
    public static int subarraySum(int[] nums, int k) {

        //这个是我能想到的最简单的思路
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum =sum+ nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
