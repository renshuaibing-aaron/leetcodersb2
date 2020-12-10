        package com.aaron.ren.leetcode;

        import java.util.*;

        public class Main {

            public static void main(String[] args) {
                // System.out.println(lengthOfLongestSubstring("aabaab!bb"));
                // System.out.println(longestPalindrome("12345"));
                int[] nums = {-1, 0, 1, 2, -1, -4};
               // System.out.println(generateParenthesis(3));
            }
        /*
        [
                [1,3,1],
                [1,5,1],
                [4,2,1]
                ]
        */

        //1 2 3 4 5 6
       //  56 1234
        public ListNode rotateRight(ListNode head, int k) {
            //求链表的长度
            ListNode p=head;
            int i=0;
            while(p!=null){
                i++;
                p=p.next;
            }
            int i1 = k % i;
            int step=i-k; //4
            int i2=0;
            ListNode first=head;
            while(i2<step){
                first=first.next;
                i2++;
            }
            ListNode pre=head;
            while(pre.next!=null){
                pre=pre.next;
            }
            pre.next=head;
            return first;

        }


            public List<List<Integer>> pathSum(TreeNode root, int sum) {

               //典型的应用
                List<List<Integer>>  result=new ArrayList<>();
                LinkedList<Integer> tmp = new LinkedList<>();// 定义一个有序list来存储路径
                dfs(root,result,tmp,sum);
return result;
            }

            public void dfs(TreeNode node,List<List<Integer>> result, LinkedList<Integer> tmp, int sum) {
            if(node==null){
                return;
            }
            tmp.add(node.val);
            if(node.left==null&&node.right==null&&sum==node.val){
                result.add(new ArrayList<Integer>(tmp));

            }
            dfs(node.left,result,tmp,sum-node.val);
            dfs(node.right,result,tmp,sum-node.val);
            tmp.removeLast();

            }

            public class ListNode {
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