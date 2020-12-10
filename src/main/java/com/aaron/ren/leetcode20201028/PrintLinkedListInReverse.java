package com.aaron.ren.leetcode20201028;

public class PrintLinkedListInReverse {
    public void printLinkedListInReverse(ListNode head) {
        if (head == null) {
            return;
        }
        printLinkedListInReverse(head.next);
        System.out.println(head.val);

    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
