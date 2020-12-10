package com.aaron.ren.leet20200915;


//旋转数组
public class Search {

    //这个是数组里面的值都不重复
    public int searchI(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len-1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
                //如果中位数小于右侧 可以确定右侧是有序的
            } else if(nums[mid] < nums[right]){
                //巧了 有序 右侧有序 目标值还在右侧
                if(nums[mid] < target && target <= nums[right]) {
                    //那肯定移动左指针
                    left = mid+1;
                } else {
                    //不再右侧  那没法 移动右侧指针
                    right = mid-1;
                }
            }
            else{
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return -1;
    }


    //这个是数组里面的值可能有重复
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            //前半部分有序
            if (nums[left] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {  //否则，去后半部分找
                    left = mid + 1;
                }
            } else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {  //否则，去后半部分找
                    right = mid - 1;

                }
            }
        }
        //一直没找到，返回false
        return false;

    }
}
