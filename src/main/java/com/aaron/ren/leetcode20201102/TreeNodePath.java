package com.aaron.ren.leetcode20201102;

import java.util.ArrayList;
import java.util.List;

public class TreeNodePath {

    //妈的 就这个破题
    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2= new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(8);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode6;
        treeNode4.right = treeNode7;

        System.out.println(getPath(treeNode1));

    }


    public static List<String> getPath(TreeNode root){

        List<String> res=new ArrayList<>();

        StringBuffer path=new StringBuffer();

        if(root==null){
            return res;
        }
        dfs(res,path,root);
        return res;
    }

    private static void dfs(List<String> res, StringBuffer path, TreeNode root) {

        if(root==null){
            return;
        }
        //少一个值啊
        System.out.println("添加"+root.val);
        path.append(root.val);
        if(root.left==null&&root.right==null){
            res.add(path.toString());

        }else{

            if(root.left!=null){
                dfs(res, path, root.left);
            }
            if(root.right!=null){
                dfs(res, path, root.right);
            }

        }
        System.out.println("删除"+path.charAt(path.length()-1));
        path.deleteCharAt(path.length() - 1);

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
