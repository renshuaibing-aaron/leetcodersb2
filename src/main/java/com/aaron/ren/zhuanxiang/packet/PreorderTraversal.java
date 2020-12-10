package com.aaron.ren.zhuanxiang.packet;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {



    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        psort(root,res);
        return  res;

    }

    private void psort(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public class TreeNode {
         int val;
         TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
      }
}
