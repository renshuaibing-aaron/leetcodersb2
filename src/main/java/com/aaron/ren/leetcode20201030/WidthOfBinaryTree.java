package com.aaron.ren.leetcode20201030;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        int res=0;

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            res=Math.max(res,size);

            while(size>0){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
                size--;
            }
        }

        return res;

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
