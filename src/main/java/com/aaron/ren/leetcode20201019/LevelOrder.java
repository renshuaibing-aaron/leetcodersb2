package com.aaron.ren.leetcode20201019;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<Integer> largestValues(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> realres = new LinkedList<>();

        while (!queue.isEmpty()) {

            List<Integer>   tmp=new ArrayList<>();
          int  count =queue.size();
          int num=Integer.MIN_VALUE;
          while(count>0){
              TreeNode poll = queue.poll();
              num=Math.max(num,poll.val);
              tmp.add(poll.val);
              if(poll.left!=null){
                  queue.add(poll.left);
              }

              if(poll.right!=null){
                  queue.add(poll.right);
              }
              count--;
          }
            realres.add(num);
            res.add(tmp);
        }
return realres;
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
