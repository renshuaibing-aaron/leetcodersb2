package com.aaron.ren.leet20200909;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        //一般怎么描述呢
        dfs(res,candidates,tmp,target,0);
        return  res;
    }

    /**
     *
     * @param res
     * @param candidates
     * @param tmp
     * @param target
     * @param tmpsum
     */
    private void dfs(List<List<Integer>> res, int[] candidates, List<Integer> tmp,int target,int tmpsum) {
        if(target==tmpsum){
            res.add(tmp);
        }

        for(int i=0;i<candidates.length;i++){



        }

    }
}
