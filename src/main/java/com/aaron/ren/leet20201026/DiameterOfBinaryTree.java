package com.aaron.ren.leet20201026;

public class DiameterOfBinaryTree {

    private static Integer res = 0;

    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(null));
    }

    public static int diameterOfBinaryTree(TreeNode root) {

        //树的直径等于 根节点左右子树和-2

        dfs(root);

        return res;

    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        int left = getLength(root.left);
        int right = getLength(root.right);

        res = Math.max(res, left + right);

        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }

    }

    public static int getLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = getLength(root.left);
        int right = getLength(root.right);

        return Math.max(left, right) + 1;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
