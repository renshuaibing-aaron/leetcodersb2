package com.aaron.ren.leet20200912;

public class FindMaxConsecutiveOnes {

    //[1,1,0,1,1,1]
    public int findMaxConsecutiveOnes(int[] nums) {
        //动态规划
        int[] count=new int[nums.length];
        int res=Integer.MIN_VALUE;

        if(nums[0]==1){
            count[0] =1;
        }else{
            count[0]=0;
        }
        res=Math.max(res, count[0]);
        for (int  i=1;i<nums.length;i++){

            if(nums[i]==1){
                count[i]=count[i-1]+1;
            }else{
                count[i]=0;
            }
            res=Math.max(res,count[i]);
        }
        return res;


    }
}
