package com.aaron.ren.zhuanxiang.packet;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};


    }

    //旋转数组的最小值

    //[10,9,2,5,3,7,101,18]
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>();
        if(root.left!=null){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right);
        }
        return  list;

    }


     public static  class ListNode {
          int val;
          ListNode next;
         ListNode(int x) { val = x; }
     }

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
      }

}
