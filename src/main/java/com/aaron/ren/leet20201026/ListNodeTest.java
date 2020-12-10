package com.aaron.ren.leet20201026;

public class ListNodeTest {

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);


        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        printListNode(node1);
    }

    public boolean isPalindrome(ListNode head) {
       ListNode temp = head;
        return check(head,temp);
    }

    private boolean check(ListNode head,ListNode temp) {
        if (head == null) {
            return true;
        }
        boolean res = check(head.next,temp) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }



    private static void printListNode(ListNode head) {
        if (head == null) {
            return;
        }
        printListNode(head.next);
        System.out.println(head.val);
    }


    private  static  class ListNode{

        private  ListNode next;
        private  int val;

        public ListNode(int i) {
            this.val=i;
        }
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;
        //通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }
        //反转后半部分链表
        slow = reverse(slow);

        fast = head;
        while (slow != null) {
            //然后比较，判断节点值是否相等
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


}
