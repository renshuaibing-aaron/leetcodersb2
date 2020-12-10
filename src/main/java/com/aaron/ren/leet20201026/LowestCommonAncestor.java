package com.aaron.ren.leet20201026;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        TreeNode  node6=new TreeNode(6);
        TreeNode  node2=new TreeNode(2);
        TreeNode  node8=new TreeNode(8);
        TreeNode  node0=new TreeNode(0);
        TreeNode  node4=new TreeNode(4);
        TreeNode  node7=new TreeNode(7);
        TreeNode  node9=new TreeNode(9);
        TreeNode  node3=new TreeNode(3);
        TreeNode  node5=new TreeNode(5);

        node6.left=node2;
        node6.right=node8;
        node2.left=node0;
        node2.right=node4;
        node8.left=node7;
        node8.right=node9;
        node4.left=node3;
        node4.right=node5;

        TreeNode treeNode = lowestCommonAncestor(node6, node2, node8);

        System.out.println(treeNode.val);

    }

    public static  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null||p==null||q==null){
            return  null;
        }
        if(root.left!=null&&root.right!=null){
            if((root.left.equals(p)&&root.right.equals(q))||(root.right.equals(p)&&root.left.equals(q))){
                return root;
            }
        }

        if(root.equals(p)||root.equals(q)){
            return root;
        }else{
            TreeNode treeNodeleft = lowestCommonAncestor(root.left, p, q);
            if(treeNodeleft!=null){
                return treeNodeleft;
            }
            TreeNode treeNoderight = lowestCommonAncestor(root.right, p, q);
            if(treeNoderight!=null){
                return treeNoderight;
            }
        }
        return  null;

    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {//当遍历到叶结点后就会返回null
            return root;
        }
        if (root == p || root == q) {//当找到p或者q的是时候就会返回pq
            return root;/*当然，值得一提的是，如果公共祖先是自己（pq），并不需要寻找另外
                     一个，我们在执行前序遍历会先找上面的，后找下面的，我们会直接返回公共祖先。*/
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);//返回的结点进行保存，可能是null
        TreeNode right = lowestCommonAncestor2(root.right, p, q);//也可能是pq，还可能是公共祖先
        if (left != null && right != null) {
            return root;//如果左右都存在，就说明pq都出现了，这就是，公共祖先，此时不用考虑公共祖先是自己的情况，因为上面已经做过判断了。
        } else if (left != null) {//否则我们返回已经找到的那个值（存储在left，与right中），p或者q
            return left;//还有一种可能就是，由下面返回的公共祖先，并将这个值一路返回到最表层
        } else if (right != null) {
            return right;
        }
        return null;
    }




    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

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
