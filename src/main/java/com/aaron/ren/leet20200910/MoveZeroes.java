package com.aaron.ren.leet20200910;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arra={0,1,0,3,12};
        moveZeroes(arra);
        System.out.println(Arrays.toString(arra));
    }


    //移动0  输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    //牛逼的双指针法
    public static  void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }

    }
}
