package com.aaron.ren.leetcode20201120;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/21 10:31
 */

public class Partition {

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);

        node1.next=node2;
        node2.next=node3;
        partition(node1);

        System.out.println(node1.val);

    }

    //输入: head = 1->4->3->2->5->2, x = 3
   // 输出: 1->2->2->4->3->5
    //注意java中的传值情况
    public static void partition(ListNode head) {

        int res=0;
        while(head!=null){
            head=head.next;
            res++;
        }
        System.out.println(res);


    }

    public static  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
