package com.aaron.ren.leet20200911;

import java.util.Arrays;

public class MinMoves2 {

    //[1,2,3]
    public int minMoves2(int[] nums) {

        //这个题没啥意思  求各个数和中位数的差值的和

        Arrays.sort(nums);
        int i=0,j= nums.length-1;

        int res=0;
        while(i<j){
            res=nums[j]-nums[i]+res;
            i++;
            j--;
        }

        return  res;

    }
}
