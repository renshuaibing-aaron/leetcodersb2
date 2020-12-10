package com.aaron.ren.leet20200914;

import java.util.Arrays;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {

        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
        if(nums[i]==nums[i+1]){
            return nums[i];

        }
        }
        return -1;
    }
}
