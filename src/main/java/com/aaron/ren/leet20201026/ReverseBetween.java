package com.aaron.ren.leet20201026;

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (m > 1) {
            prev = prev.next;
            m--;
            n--;
        }
        head = prev.next;
        while (n > 1) {
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = prev.next;
            prev.next = next;
            n--;
        }
        return dummy.next;
    }

    private  static  class ListNode{

        private ListNode next;
        private  int val;

        public ListNode(int i) {
            this.val=i;
        }
    }
}
