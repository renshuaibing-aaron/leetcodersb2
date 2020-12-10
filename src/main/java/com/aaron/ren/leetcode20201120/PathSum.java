package com.aaron.ren.leetcode20201120;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/21 11:08
 */

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        List<List<Integer>> res=new LinkedList<>();
        Deque<Integer> path=new LinkedList<>();
        boolean dfs = dfs(root, sum, res, path);

        return dfs;

    }

    private boolean dfs(TreeNode root, int sum, List<List<Integer>> res, Deque<Integer> path) {
        if(root==null){
            return false;
        }
        path.addLast(root.val);
        if(root.left==null&&root.right==null&&sum==root.val){
            return  true;
        }
        dfs(root.left, sum-root.val, res, path);
        dfs(root.right, sum-root.val, res, path);
        path.removeLast();
        return  false;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
