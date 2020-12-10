package com.aaron.ren.leetcode20201028;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        dfs(res, root, 0);
        return res;
    }

    //利用这个写法 怎么保证 出现右视图呢
    private void dfs(List<Integer> res, TreeNode root, int i) {
        if (root != null) {
            if(res.size()==i){
                res.add(root.val);
            }

            if(root.right!=null){
                dfs(res, root.right, i + 1);
            }
           if(root.left!=null){
               dfs(res, root.left, i + 1);
           }

        }

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
