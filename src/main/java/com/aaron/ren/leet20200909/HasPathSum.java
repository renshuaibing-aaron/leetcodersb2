package com.aaron.ren.leet20200909;

public class HasPathSum {


    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }


    public  static  class TreeNode {
        int val;
          TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

}
