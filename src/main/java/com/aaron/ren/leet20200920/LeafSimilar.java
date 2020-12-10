package com.aaron.ren.leet20200920;

public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
       return false;
    }

     public class TreeNode {
         int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
         TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
            this.right = right;
          }
     }
}
