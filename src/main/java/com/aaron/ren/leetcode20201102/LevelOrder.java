package com.aaron.ren.leetcode20201102;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        //BFS  用迭代

        //这里
        if(root==null){
            return  new ArrayList<>();
        }

        Queue<TreeNode>  queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        queue.add(root);

        int level=1;
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer>  tmp=new ArrayList<>();
            while(count>0){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
                tmp.add(poll.val);
                count--;

            }
            if(level%2==1){
                Collections.reverse(tmp);
            }
            res.add(tmp);
            level++;
        }

        return  res;
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
