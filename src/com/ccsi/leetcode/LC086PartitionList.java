package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/14.
 */
public class LC086PartitionList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(2);

        ListNode res=partition1(head,3);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }

    public static ListNode partition(ListNode head,int x){
        if(head==null||head.next==null)return head;

        ListNode firstDummyHead=new ListNode(0);
        ListNode last=firstDummyHead;

        ListNode secondDummyHead=new ListNode(0);
        secondDummyHead.next=head;
        ListNode pre=secondDummyHead;
        ListNode curr=head;
        ListNode next=head.next;

        while(next!=null){
            if(curr.val<x){
                last.next=curr;
                last=last.next;
                last.next=null;

                pre.next=next;
            }else{
                pre=curr;
            }
            curr=next;
            next=next.next;
        }
        //收尾
        if(curr.val<x) {
            last.next = curr;
            last = last.next;
            last.next = null;

            pre.next=null;
        }

        last.next=secondDummyHead.next;
        return firstDummyHead.next;
    }

    public static ListNode partition1(ListNode head,int x){
        if(head==null||head.next==null)return head;

        ListNode firstDummyHead=new ListNode(0);
        ListNode last=firstDummyHead;

        ListNode secondDummyHead=new ListNode(0);
        secondDummyHead.next=head;
        ListNode pre=secondDummyHead;
        ListNode curr=head;

        while(curr!=null){
            if(curr.val<x){
                last.next=curr;
                last=last.next;

                pre.next=curr.next;
            }else{
                pre=curr;
            }
            curr=curr.next;
        }

        last.next=secondDummyHead.next;
        return firstDummyHead.next;
    }
}
