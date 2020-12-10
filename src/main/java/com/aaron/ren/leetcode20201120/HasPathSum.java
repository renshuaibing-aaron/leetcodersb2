package com.aaron.ren.leetcode20201120;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/21 11:01
 */

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {

        if(root==null){
            return false;
        }
        //肯定是利用回溯了
       boolean res= dfs(root,sum);
       return res;

    }

    private boolean dfs(TreeNode root, int sum) {
        if(root.left==null&&root.right==null&&sum==0){
            return true;
        }
        if(root.left!=null){
            dfs(root.left, sum-root.val);
        }
       if(root.right!=null){
           dfs(root.right, sum-root.val);
       }

        return false;
    }

    public class TreeNode {
         int val;
          TreeNode left;
         TreeNode right;
          TreeNode(int x) { val = x; }
      }
}
