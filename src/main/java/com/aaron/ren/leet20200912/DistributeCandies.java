package com.aaron.ren.leet20200912;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {


    //candies = [1,1,2,2,3,3]
    //每一个数字代表的是种类
    //每一个数字代表的是一个
       //   A  B C  D  E  F  --3
    //还不如 A A B B  C C   --3
    //     A  A  A A  A A   --1
    //     A A AA  BB    --  2
    //求最大的种类数
    //  其实可以分析 最大是一半 最小是种类的数量
    public int distributeCandies(int[] candies) {
        int count=candies.length/2; //

        Set<Integer> set=new HashSet<>();

        for(int i=0;i<candies.length;i++){
            set.add(candies[i]);
        }
        //求种类
        return Math.min(set.size(),count);


    }
}
