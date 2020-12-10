package com.aaron.ren.leet2020;


public class DiameterOfBinaryTree {

    /**
     * 求树的最大直径
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
      int  ans = 1;
        depth(root, ans);
        return ans - 1;
    }
    public int depth(TreeNode node,int ans) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left,ans); // 左儿子为根的子树的深度
        int R = depth(node.right,ans); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

    public static  class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
