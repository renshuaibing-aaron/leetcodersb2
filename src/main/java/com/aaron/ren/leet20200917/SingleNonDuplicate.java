package com.aaron.ren.leet20200917;

public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {

        //这个题简单 直接用位操作即可
        int res=0;

        for(int num:nums){
            res=res^num;

        }
        return res;

    }
}
