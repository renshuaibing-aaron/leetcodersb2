package com.aaron.ren.leetcode20201019;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

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

    }

    public List<Integer> pre(TreeNode root, int sum) {

        List<Integer>  res=new ArrayList<>();

        Deque<Integer>  path=new LinkedList<>();


        preorder(root,res);
        return res;

    }

    private void preorder(TreeNode root, List<Integer> res) {

        if(root!=null){
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);

        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>>  res=new ArrayList<>();

        Deque<Integer>  path=new LinkedList<>();


        dfs(res,root,sum,path);
        return res;

    }

    private static void dfs(List<List<Integer>> res, TreeNode    root, int sum, Deque<Integer> path) {

        if(root==null){
            return;
        }
        System.out.println("=加入=="+root.val);
        path.addLast(root.val);
        sum=sum-root.val;
        if(root.left==null&&root.right==null&&sum==0){
            res.add(new ArrayList<>(path));
          //  return;
        }else{
          dfs(res,root.left,sum,path);
          dfs(res,root.right,sum,path);
        }

        Integer integer = path.removeLast();
        System.out.println("===退出="+integer);

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
