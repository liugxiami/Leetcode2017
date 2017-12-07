package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/12/6.
 */
public class LC206ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        ListNode res=reverseList1(head);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    //method1 loop
    public static ListNode reverseList(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode pre=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    //method2 递归
    public static ListNode reverseList1(ListNode head){
        if(head==null||head.next==null)return head;

        ListNode next=head.next;
        head.next=null;

        ListNode newHead=reverseList1(next);
        next.next=head;

        return newHead;
    }
}
