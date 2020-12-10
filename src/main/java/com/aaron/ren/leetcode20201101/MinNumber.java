package com.aaron.ren.leetcode20201101;

import java.util.*;

public class MinNumber {

    //3033459"
    //3303459
    public static void main(String[] args) {
        int[] nums={3,30,34,5,9};
        System.out.println(minNumber(nums));
    }
    public static  String minNumber(int[] nums) {

     List<String>  list=new ArrayList<>();
     for(int i=0;i<nums.length;i++){
         list.add(String.valueOf(nums[i]));
     }
     Collections.sort(list,  (x, y) -> (x + y).compareTo(y + x));

        System.out.println(list);
     //连接list
        StringBuffer stringBuffer=new StringBuffer();
        for(String item :list){
            stringBuffer.append(item);
        }

        return stringBuffer.toString();


}
}
