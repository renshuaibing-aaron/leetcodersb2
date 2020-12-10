package com.aaron.ren.leet20200913;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {


  /*  输入: [2,2,3,2,4,4,4]
    输出: 3*/
   //找出出现一次的数字 其他的都是出现三次
    //没有思路
    public int singleNumber(int[] nums) {

        //首先一个简单的方法可以实现
        //3×(a+b+c)−(a+a+a+b+b+b+c)=2c
        Set<Integer>  set=new HashSet<>();
        Long ans=0L;
        Long ans2=0L;
        for(int num:nums){
            set.add(num);
            ans=ans+num;
        }

        for(int num :set){
            ans2=ans2+num;
        }

        return (int) ((3*ans2-ans)/2);

    }
}
