package com.aaron.ren.leet20200914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
              if(nums[i-1]!=i){
                  res.add(i);
              }

        }
        return res;

    }
}
