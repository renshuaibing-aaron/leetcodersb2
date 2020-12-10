package com.aaron.ren.zhuanxiang.list;

/**
 * @author renshuaibing
 * @version 1.0
 * @description: TODO
 * @date 2020/11/21 16:19
 */

public class ReverseBetween {
    //链表的反转 怎么实现 递归算法和迭代算法
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
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
