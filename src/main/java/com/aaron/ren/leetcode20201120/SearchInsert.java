package com.aaron.ren.leetcode20201120;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/22 8:27
 */

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid=left+right>>1;

            if(nums[mid]==target){
                return  mid;
            }
            if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return right;
    }
}
