package com.aaron.ren.leet20201026;

import java.util.*;

public class Permute {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        permute(nums);
    }

    //全排列  1 2 3
    public static  List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res=new ArrayList<>();

        if(length==0){
            return res;
        }
        boolean[] isflag=new boolean[nums.length];

        Deque<Integer> queue=new ArrayDeque(nums.length);
        dfs(res,nums,isflag,queue);
        return res;

    }

    private static void dfs(List<List<Integer>> res, int[] nums, boolean[] isflag, Deque queue) {
        if(queue.size()==nums.length){
            // res.add(tmp);  这里不行
            System.out.println("==完成=="+queue);
            res.add(new ArrayList<Integer>(queue));  //

            return;
        }
        for(int i=0;i<nums.length;i++){

            if(isflag[i]==false){
                isflag[i]=true;
                System.out.println("===加入==="+nums[i]);
                queue.addLast(nums[i]);
                dfs(res,nums,isflag,queue);

                //怎么回退
                Object o = queue.removeLast();

                System.out.println("===推出==="+o);
                isflag[i]=false;
            }

        }
    }
}
