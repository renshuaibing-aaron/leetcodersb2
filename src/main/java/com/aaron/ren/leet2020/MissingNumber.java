package com.aaron.ren.leet2020;

public class MissingNumber {

    public int missingNumber(int[] nums) {

        int n = nums.length;
        //肯定的是数组本来的和是 0  -n

        int resalSum=0;
        for(int i=0;i<n;i++){
            resalSum=resalSum+nums[i];
        }
        int sum=(1+n)*n/2;

        return sum -resalSum;
    }

    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

}
