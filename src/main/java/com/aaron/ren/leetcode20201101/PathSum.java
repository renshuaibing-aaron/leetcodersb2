package com.aaron.ren.leetcode20201101;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    private void dfs(TreeNode root, List<Integer> res) {

        if(root!=null){
            res.add(root.val);
            dfs(root.left, res);
            dfs(root.right, res);

        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>>  res=new ArrayList<>();

        Deque<Integer> path=new LinkedList<>();


        dfs(res,root,sum,path);
        return res;

    }

    private void dfs(List<List<Integer>> res, TreeNode    root, int sum, Deque<Integer> path) {

        if(root==null){
            return;
        }
        path.addLast(root.val);
        sum=sum-root.val;
        if(root.left==null&&root.right==null&&sum==0){
            res.add(new ArrayList<>(path));
            //
            //   return;
        }else{
            dfs(res,root.left,sum,path);
            dfs(res,root.right,sum,path);
        }

        path.removeLast();

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
