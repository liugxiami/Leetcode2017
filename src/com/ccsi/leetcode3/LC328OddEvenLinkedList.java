package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/2/27.
 */
public class LC328OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode odd=head;
        ListNode even=head.next;
        while(even!=null&&even.next!=null){
            ListNode evenHead=odd.next;

            odd.next=even.next;
            even.next=even.next.next;

            odd=odd.next;
            even=even.next;

            odd.next=evenHead;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);

        ListNode res=oddEvenList(head);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
