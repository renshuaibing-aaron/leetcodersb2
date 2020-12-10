package com.aaron.ren.leet20200919;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodes {

    /*
    *  输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
    * */
    public ListNode removeDuplicateNodes(ListNode head) {

        Set<Integer> set=new HashSet<>();
        ListNode dumpHead=new ListNode(-1);
        dumpHead.next=head;

        ListNode pre=head;

        while(pre!=null){
            if(!set.contains(pre.val)){
                set.add(pre.val);
                pre=pre.next;
                dumpHead=dumpHead.next;
            }else{
                dumpHead.next=pre.next;
                pre=pre.next;

            }
        }

        return head;

    }

     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}
