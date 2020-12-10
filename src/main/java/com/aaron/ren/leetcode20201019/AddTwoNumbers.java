package com.aaron.ren.leetcode20201019;

public class AddTwoNumbers {

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return root.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int jinwei=0;

        ListNode dummy=new ListNode(-1);
        ListNode pre=dummy;
        int q=0;
        while(l1!=null&&l2!=null){
            int sum=l1.val+l2.val+jinwei;
            int i = sum % 10;

            jinwei = sum / 10;

            ListNode node=new ListNode(i);
            if(q==0){
                pre=node;
                q=1;
            }else{
                pre.next=node;
                pre=node;
            }

            l1=l1.next;
            l2=l2.next;


        }
        if(l1!=null){
            pre.next=l1;
        }

        if(l2!=null){
            pre.next=l2;
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
