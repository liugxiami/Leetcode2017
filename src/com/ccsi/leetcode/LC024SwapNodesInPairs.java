package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/27.
 */
public class LC024SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        //l1.next.next=new ListNode(5);
        //l1.next.next.next=new ListNode(9);
        //l1.next.next.next.next=new ListNode(13);

        ListNode result=swapPairs1(l1);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    public static ListNode swapPairs(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode dummyHead=new ListNode(0);
        ListNode temp=dummyHead;
        temp.next=head;

        while(temp.next!=null&&temp.next.next!=null){
            ListNode first=temp.next;
            ListNode second=first.next;
            temp.next=second;
            first.next=second.next;
            second.next=first;

            temp=first;
        }
        return dummyHead.next;
    }
    public static ListNode swapPairs1(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode dummyHead=new ListNode(0);
        ListNode temp=dummyHead;

        while(temp.next!=null&&temp.next.next!=null){
            ListNode first=temp.next;
            ListNode second=temp.next.next;
            temp.next=second;
            first.next=second.next;
            second.next=first;

            temp=first;
        }
        return dummyHead.next;
    }
}
