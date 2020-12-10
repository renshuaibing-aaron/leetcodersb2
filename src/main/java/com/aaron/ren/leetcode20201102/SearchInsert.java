package com.aaron.ren.leetcode20201102;

public class SearchInsert {


    //最简单的二分查找  也特码写不好吗
    public int search(int[] nums, int target) {
        int mid, left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public int searchInsert(int[] nums, int target) {

        //没啥好说的  直接二分查找 关键时考试的时
        int high = nums.length - 1;
        int low = 0;
        while ( low <= high ) {
            int mid = (low + high )/2;
            if ( target > nums[mid]) {
                low = mid + 1;
            }else if ( target < nums[mid]) {
                high = mid - 1;
            }else {
                return mid;
            }
        }
        //这里直接返回low 是何意呢？？
        return low;
    }

    //输入: [1,3,5,6], 7
    //输出: 4
    public int searchInsert2(int[] nums, int target) {
        //单调数组
        int start=0;
        int end=nums.length-1;

        while(start<end){
            int mid=start+end>>2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=target){
                end=mid-1;
            }else{
                start=mid+1;
            }

        }

        return -1;

    }
}
