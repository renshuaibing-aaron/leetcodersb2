package com.aaron.ren.leetcode20201120;

import java.util.Arrays;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/20 22:46
 */

public class Merge {

    public static void main(String[] args) {
        int[] nums1={0,1,2,3,0,0,0,0};
        int [] nums2={1,1,3,4};
        merge(nums1,4,nums2,4);

        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1;
        int right=n-1;
        int index=m+n-1;
        while(left>=0&&right>=0){
            if(nums1[left]<nums2[right]){
                 nums1[index]=nums2[right];
                 right--;
            }else if(nums1[left]>nums2[right]){
                nums1[index]=nums1[left];
                left--;
            }else{
                nums1[index]=nums1[left];
                left--;
                right--;
            }
            index--;
        }

        System.arraycopy(nums2, 0, nums1, 0, right + 1);

    }

}
