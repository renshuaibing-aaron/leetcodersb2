package com.aaron.ren.zhuanxiang.tree;

//求树的最近公共祖先
public class LCATree {



    //求node1和node2 的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if(root==null||p==null||q==null){
        return null;
    }
    if(root==p||root==q){
        return  root;
    }

    //在左分支里面找pq
    TreeNode  leftNode=lowestCommonAncestor(root.left, p, q);
    //在右分支里面找pq
    TreeNode  rightNode=lowestCommonAncestor(root.right, p, q);
    if(leftNode!=null&&rightNode!=null){
        return root;
    }
    if(leftNode==null){
        return rightNode;
    }
        return leftNode;


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
