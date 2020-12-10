package com.aaron.ren.leetcode20201101;

public class ReverseList {


    //链表反转
    public ListNode reverseList(ListNode head) {

        ListNode dummy=new ListNode(-1);

        ListNode cur=dummy;

        while(head!=null){
            dummy.next=head;
            ListNode tmp=head;
            head=head.next;
            tmp.next=cur;
            cur=tmp;
        }

        return dummy.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
