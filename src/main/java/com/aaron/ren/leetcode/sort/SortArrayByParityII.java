package com.aaron.ren.leetcode.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
      List<Integer> odd=new ArrayList<>();
      List<Integer> even=new ArrayList<>();

        for(int item:A){
            if(item%2==0){
                even.add(item);
            }else{
                odd.add(item);
            }

        }
        int p=0;
        int q=0;
        for(int i=0;i<A.length;i++){
            if(i%2==0){
                A[i]=even.get(p);
                p++;
            }else{
                A[i]=odd.get(q);
                q++;
            }

        }
        return A;


    }
}