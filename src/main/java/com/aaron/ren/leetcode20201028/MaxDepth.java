package com.aaron.ren.leetcode20201028;

public class MaxDepth {



    //树的最大深度
    public int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int  right=maxDepth(root.right);

        return  left>right?left+1:right+1;

    }

    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
