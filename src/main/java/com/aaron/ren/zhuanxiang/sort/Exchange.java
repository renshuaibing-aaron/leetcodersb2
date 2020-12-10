package com.aaron.ren.zhuanxiang.sort;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/22 20:57
 */

public class Exchange {

    //对数组进行重新排序 使其奇数在前 偶数在后
    //利用双指针实现
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while(i < j) {
            while(i < j && (nums[i] & 1) == 1) {
                i++;
            }
            while(i < j && (nums[j] & 1) == 0) {
                j--;
            }
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

}
