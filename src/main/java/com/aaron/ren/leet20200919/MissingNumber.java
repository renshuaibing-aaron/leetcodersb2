package com.aaron.ren.leet20200919;

public class MissingNumber {
    public int missingNumber(int[] nums) {



        //排序的数字
        //0,1,2,3,4,5,6,7,9    长度是9
        int i=0;
        for( i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }

        }
        if(i==nums.length){
           return i;
        }
 return -1;
    }
}
