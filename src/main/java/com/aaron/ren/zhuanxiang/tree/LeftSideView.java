package com.aaron.ren.zhuanxiang.tree;

import java.util.ArrayList;
import java.util.List;


//树的左右司徒
public class LeftSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        dfs(res, root, 0);
        return res;
    }

    //利用这个写法 怎么保证 出现右视图呢
    //牛逼的 写法 增加一个list 就可以保证了 判断是不是第一进入的
    //仔细思考 树的遍历 前序遍历的写法
    private void dfs(List<Integer> res, TreeNode root, int i) {
          if(root!=null){
              if(res.size()==i){
                  res.add(root.val);
              }

              if(root.left!=null){
                  dfs(res, root.left, i+1);
              }

              if(root.right!=null){
                  dfs(res, root.right, i+1);
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
