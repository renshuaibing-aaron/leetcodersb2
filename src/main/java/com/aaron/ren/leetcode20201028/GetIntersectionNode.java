package com.aaron.ren.leetcode20201028;

public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode nodeA4=new ListNode(4);
        ListNode nodeA1=new ListNode(1);
        ListNode nodeA8=new ListNode(8);
        ListNode nodeA41=new ListNode(4);
        ListNode nodeA51=new ListNode(5);

        nodeA4.next=nodeA1;
        nodeA1.next=nodeA8;
        nodeA8.next=nodeA41;
        nodeA41.next=nodeA51;


        ListNode nodeB5=new ListNode(5);
        ListNode nodeB0=new ListNode(0);
        ListNode nodeB1=new ListNode(1);

        nodeB5.next=nodeB0;
        nodeB0.next=nodeB1;
        nodeB1.next=nodeA8;

        System.out.println(getIntersectionNode(nodeA4, nodeB5));

    }

    //相交链表
    //找出长度
    public static  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listNodeA=headA;
        ListNode listNodeB=headB;
        int lengthA=getLength(listNodeA);
        int lengthB=getLength(listNodeB);

        int abs = Math.abs(lengthA - lengthB);
        if(lengthA>lengthB){

            while(abs>0){
                headA=headA.next;
                abs--;
            }

            while(headA!=null&&headB!=null){

                if(headA.equals(headB)){
                    return headA;
                }else{
                    headA=headA.next;
                    headB=headB.next;
                }
            }


        }else{
            while(abs>0){
                headB=headB.next;
                abs--;
            }

            while(headA!=null&&headB!=null){

                if(headA.equals(headB)){
                    return headB;
                }else{
                    headA=headA.next;
                    headB=headB.next;
                }
            }

        }

        return null;
    }

    private static int getLength(ListNode headA) {
        int res=0;
        while(headA!=null){
            res++;
            headA=headA.next;
        }
        return res;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
