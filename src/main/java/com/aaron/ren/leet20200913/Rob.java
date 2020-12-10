package com.aaron.ren.leet20200913;

public class Rob {


    public int rob(int[] nums) {
        int[] res=new int[nums.length];

        if(nums.length==1){
            return  nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

      res[0]=nums[0];
        res[1]=Math.max(nums[0],nums[1]);
        //i-2  i-1  i
        //res[i]=Math.max(res[i-2]+nums[i],res[i-1]);  //取i
        for(int i=2;i<nums.length;i++){
            res[i]=Math.max(res[i-2]+nums[i],res[i-1]);
        }

        return res[nums.length-1];

    }
}
