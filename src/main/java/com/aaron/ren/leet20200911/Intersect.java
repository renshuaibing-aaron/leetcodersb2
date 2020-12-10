package com.aaron.ren.leet20200911;

import java.util.Arrays;
import java.util.Collections;

public class Intersect {

    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        intersect(nums1,nums2);
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
      /*todo  求集合的交集
              JDK里面有没有实现的啊
        */
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0,j=0;
        int[] res=new int[nums2.length];
        int index=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]==nums2[j]){
                res[index]=nums1[i];
                i++;
                j++;
                index++;
            }else{
                j++;
            }
        }
            //数组的复制是怎么实现的呢
        return Arrays.copyOfRange(res, 0, index-1);

    }
}
