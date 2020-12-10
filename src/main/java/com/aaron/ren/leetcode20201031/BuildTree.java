package com.aaron.ren.leetcode20201031;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    //利用树的先序和中序 构造树
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        if(preorder.length==0){
            return null;
        }
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return  dfs(map,preorder,0,preorder.length-1,inorder,0,inorder.length-1);



    }

    private TreeNode dfs(Map<Integer,Integer> map,int[] preorder, int p, int q, int[] inorder, int m, int n) {

        int rootval = preorder[p];
        Integer index = map.get(rootval);

        TreeNode root=new TreeNode(rootval);
        //关键是另外两个区间怎么设定呢
        root.left=dfs(map,preorder,1,index+1,inorder,0,index);
        root.right=dfs(map,preorder,index+1,n,inorder,index+1,n);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
