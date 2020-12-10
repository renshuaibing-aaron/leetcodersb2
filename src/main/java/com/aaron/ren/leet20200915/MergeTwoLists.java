package com.aaron.ren.leet20200915;

public class MergeTwoLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        //学习优秀的代码
        ListNode dummyHead=new ListNode(0);
        ListNode cur=dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next=l2;
                cur=cur.next;
                l2=l2.next;
            }
        }

if(l1!=null){
    cur.next=l1;
}
if(l2!=null){
    cur.next=l2;
}
 return dummyHead.next;
    }
   public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

}

