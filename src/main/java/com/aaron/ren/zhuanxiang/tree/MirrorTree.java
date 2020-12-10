package com.aaron.ren.zhuanxiang.tree;

//反转二叉树
public class MirrorTree {

    //获取树的对称树
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }

        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;



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
