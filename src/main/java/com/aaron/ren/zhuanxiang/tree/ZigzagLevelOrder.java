package com.aaron.ren.zhuanxiang.tree;

import java.util.*;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/21 15:50
 */

public class ZigzagLevelOrder {

    //关键是锯齿形怎么控制呢


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag=0;
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                tmp.add(poll.val);
                size--;
            }
            if(flag%2==0){
                res.add(tmp);
            }else {
                //进行逆序输出 怎么实现呢
                Collections.reverse(tmp);
                res.add(tmp);
            }
            flag++;

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
