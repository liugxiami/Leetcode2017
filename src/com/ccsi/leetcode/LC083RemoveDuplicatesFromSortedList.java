package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/12.
 */
public class LC083RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next.next=new ListNode(5);
        ListNode res=deleteDuplicates(head);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head){
        if(head==null||head.next==null)return head;

        ListNode curr=head;
        ListNode next=head.next;

        while(next!=null){
            if(curr.val==next.val){
                curr.next=next.next;
            }else{
                curr=next;
            }
            next=next.next;
        }
        return head;
    }
}
