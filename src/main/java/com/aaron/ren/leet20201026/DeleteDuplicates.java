package com.aaron.ren.leet20201026;

public class DeleteDuplicates {

    public ListNode deleteDuplicates2(ListNode head) {

        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode post=dummy;
        ListNode front=head.next;

        while(front!=null){
            if(front.val==head.val){
               while(front!=null&&front.val==head.val){
                   front=front.next;
               }
               head=front;
               if(front!=null){
                    front=front.next;
               }

               post.next=head;

            }else{
                front=front.next;
                head=head.next;
                post=post.next;
            }

        }

        return dummy.next;


    }
    //这个是删除一个  如果是删除所有的重复节点怎么处理
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = head.next;

        while (curr != null) {
            if (curr.val == head.val) {
                head = curr.next;
            } else {
                head = head.next;

            }
            curr = curr.next;

        }
        return dummy.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
