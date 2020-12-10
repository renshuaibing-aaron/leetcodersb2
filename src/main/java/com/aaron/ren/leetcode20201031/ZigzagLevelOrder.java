package com.aaron.ren.leetcode20201031;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> res=new ArrayList<>();

        dfs(res,root);
return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> jishu=new Stack<>();
        Stack<TreeNode>  oushu=new Stack<>();

        jishu.push(root);

        while(!jishu.isEmpty()||!oushu.isEmpty()){
            List<Integer>  tmp=new ArrayList<>();

            if(!jishu.isEmpty()){
                while(!jishu.isEmpty()){
                    TreeNode pop = jishu.pop();
                    tmp.add(pop.val);
                    if(pop.left!=null){
                        oushu.add(pop.left);
                    }
                    if(pop.right!=null){
                        oushu.add(pop.right);
                    }
                }
            }else{
                while(!oushu.isEmpty()){
                    TreeNode pop = oushu.pop();
                    tmp.add(pop.val);
                    if(pop.right!=null){
                        jishu.add(pop.right);
                    }
                    if(pop.left!=null){
                        jishu.add(pop.left);
                    }
                }
            }

            res.add(tmp);
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
