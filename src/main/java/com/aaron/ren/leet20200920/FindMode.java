package com.aaron.ren.leet20200920;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindMode {

    public int[] findMode(TreeNode root) {
        //二叉树 找众数
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> finalMap =new HashMap<>();

        dfs(map,root);

        //怎么根据map的value值进行排序
        map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        Set<Integer> integers = finalMap.keySet();

        Integer res =0;
        for(Integer  item :integers){
            res = finalMap.get(item);
        }

        return new int[]{res};

    }

    private void dfs(Map<Integer, Integer> map, TreeNode root) {

        if(root!=null){
            map.put(root.val,map.getOrDefault(root.val,0)+1);
        }else{
            return;
        }

        dfs(map,root.left);
        dfs(map,root.right);

    }

    public class TreeNode {
          int val;
         TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
      }
}
