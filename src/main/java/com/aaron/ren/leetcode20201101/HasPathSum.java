package com.aaron.ren.leetcode20201101;

import java.util.*;

public class HasPathSum {

    public  List<List<Integer>>  hasPathSum(TreeNode root, int sum) {

        if(root==null){
            return null;
        }

        Deque<Integer> path=new LinkedList<>();
      List<List<Integer>>   res=new ArrayList<>();

        dfs(root,res,path,sum);

        return res;


    }

    private void dfs(TreeNode root, List<List<Integer>> res, Deque<Integer> path, int sum) {
        if(sum==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(path));
        }
        if(sum<0){
            return;
        }
        if(root.left!=null){
            path.addLast(root.val);
            dfs(root.left, res, path, sum-root.val);
            path.removeLast();
        }
        if(root.right!=null){
            path.addLast(root.val);
            dfs(root.right, res, path, sum-root.val);
            path.removeLast();
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
