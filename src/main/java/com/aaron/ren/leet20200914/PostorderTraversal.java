package com.aaron.ren.leet20200914;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res=new ArrayList<>();

        postorderTraversal2(root,res);


        return res;

    }

    private void postorderTraversal2(TreeNode root, List<Integer> res) {
        if(root==null){
            return ;
        }
        if(root.left!=null){
            postorderTraversal2(root.left,res);
        }
        if(root.right!=null){
            postorderTraversal2(root.right,res);
        }
        res.add(root.val);
    }

    public class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
          TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
          }
      }
}
