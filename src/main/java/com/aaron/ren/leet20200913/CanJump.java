package com.aaron.ren.leet20200913;

public class CanJump {

    // 采用贪心算法 设置一个变量保存最远到达的位置
    public boolean canJump(int[] nums) {
        int rightmost = 0;
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, nums[i] + i);
                if (rightmost >= n - 1) {
                    return true;
                }

            }else{
                return  false;
            }

        }
        return  false;

    }
}
