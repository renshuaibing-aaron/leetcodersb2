package com.aaron.ren.leetcode20201030;

public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode dummynode1=new ListNode(-1);  //哨兵节点
        ListNode dummynode2=new ListNode(-1);

        ListNode node1=dummynode1;   //当前节点
        ListNode node2=dummynode2;

        while(head!=null){
            if(head.val<x){
                node1.next=head;
                node1=node1.next;
                head=head.next;
                node1.next=null;  //截断联系

            }else {
                node2.next=head;
                node2=node2.next;
                head=head.next;
                node2.next=null;
            }

        }

   node1.next=dummynode2.next;
        return dummynode1.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
