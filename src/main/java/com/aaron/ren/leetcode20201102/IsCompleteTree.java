package com.aaron.ren.leetcode20201102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsCompleteTree {
    public boolean isCompleteTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode prev = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (prev == null && node != null) {
                return false;
            }
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }
        return true;
    }

    public boolean isCompleteTree(TreeNode root) {

        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode prev = root;  //这个是标志
        while (!queue.isEmpty()) {
            TreeNode peek = queue.poll();
          /*  if (prev == null && peek != null) {
                return false;
            }*/
          if(peek==null){
              list.add(peek.val);
          }else{
              list.add(-1);
          }

            if(peek!=null){
                queue.offer(peek.left);
                queue.offer(peek.right);
            }
            prev=peek;
        }
        return true;

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
