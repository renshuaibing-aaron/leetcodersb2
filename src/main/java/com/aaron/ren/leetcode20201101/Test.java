package com.aaron.ren.leetcode20201101;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        TreeNode root1 =new TreeNode(1);
        TreeNode root2 =new TreeNode(2);
        TreeNode root3 =new TreeNode(3);
        TreeNode root31 =new TreeNode(3);
        TreeNode root32 =new TreeNode(2);

        root1.left=root2;
        root1.right=root3;

        root2.left=root31;
        root3.left=root32;

        List<List<Integer>> lists = pathSum(root1, 6);

         System.out.println(lists);

       /* TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        root1.left = root2;
        List<List<Integer>> lists = pathSum(root1, 1);

        System.out.println(lists);*/
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) {
            return new ArrayList<>();
        }

        Deque<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(root, res, path, sum);

        return res;
    }

    private static void dfs(TreeNode root, List<List<Integer>> res, Deque<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        sum=sum-root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(path));
        }else{

            dfs(root.left, res, path, sum);
            dfs(root.right, res, path, sum);
        }

        path.removeLast();

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
