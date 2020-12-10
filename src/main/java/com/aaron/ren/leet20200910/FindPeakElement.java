package com.aaron.ren.leet20200910;

public class FindPeakElement {


    //nums = [5,2,3,1]
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

}
