package com.aaron.ren.leet2020;

import java.util.ArrayList;
import java.util.List;

public class FourSum {

    /**
     * 四数之和
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    for(int m=k+1;m<nums.length;m++){

                        if(nums[i]+nums[j]+nums[k]+nums[m]==target){
                            List  <Integer> list = new ArrayList<>();
                            //怎么过滤重复的list
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[m]);
                            res.add(list);
                        }

                    }

                }

            }

        }
        return res;
    }
}
