package com.aaron.ren.nieke;

import java.util.Arrays;

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int lp1=m-1;
        int lp2=n-1;

        int index=m+n;
        while(lp1>=0&&lp2>=0){
            if(nums1[lp1]<nums2[lp2]){
              nums1[index]=nums2[lp2];
              lp2--;
            }else{
                nums1[index]=nums2[lp1];
                lp1--;
            }
            index--;
        }

        while(lp2>=0){
            nums1[index]=nums2[lp2];
            lp2--;
            index--;

        }

    }
}
