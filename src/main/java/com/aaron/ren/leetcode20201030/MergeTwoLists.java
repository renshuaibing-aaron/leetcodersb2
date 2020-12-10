package com.aaron.ren.leetcode20201030;

public class MergeTwoLists {


    //输入：1->2->4, 1->3->4
    //输出：1->1->2->3->4->4
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;

        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;

                l1=l1.next;
            }else{
                curr.next=l2;

                l2=l2.next;
            }
            curr=curr.next;
        }

        if(l1!=null){
            curr.next=l1;
        }else{
            curr.next=l2;
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
