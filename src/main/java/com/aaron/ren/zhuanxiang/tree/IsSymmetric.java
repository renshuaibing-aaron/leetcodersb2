package com.aaron.ren.zhuanxiang.tree;


//查看树是不是对称的
public class IsSymmetric {


    //判断树是不是对称的
    public boolean isSymmetric(TreeNode root) {

        return ismirror(root,root);


    }


    private boolean ismirror(TreeNode root1, TreeNode root2) {

        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null||root1.val!=root2.val){
            return false;
        }
       return ismirror(root1.left,root2.right)&&ismirror(root1.right,root2.left);

    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
