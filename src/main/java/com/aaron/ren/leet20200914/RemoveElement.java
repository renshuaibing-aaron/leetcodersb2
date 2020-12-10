package com.aaron.ren.leet20200914;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){

            if(nums[j] != val) {
                //这个地方很巧妙 采用双指针 只有不相等的时候才会进行移动 注意体会
                nums[i] = nums[j];
                i++;
            }

        }

        return i;


    }
}
