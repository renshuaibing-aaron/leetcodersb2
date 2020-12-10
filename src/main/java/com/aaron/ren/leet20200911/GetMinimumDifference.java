package com.aaron.ren.leet20200911;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetMinimumDifference {

    //
    public int getMinimumDifference(TreeNode root) {

        // 先遍历二叉树
        if(root==null){
            return 0;
        }
        List<Integer> res=new ArrayList<>();
        preorderTravel(res,root);

        Collections.sort(res);

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<res.size()-1;i++){

            ans=Math.min(ans,Math.abs(res.get(i+1)-res.get(i)));
        }

        return ans;

    }

    private void preorderTravel(List<Integer> res, TreeNode root) {

        if(root==null){
            return;
        }
        res.add(root.val);
        preorderTravel(res,root.left);
        preorderTravel(res,root.right);

    }

    public class TreeNode {
         int val;
        TreeNode left;
        TreeNode right;
         TreeNode(int x) { val = x; }
      }
}
