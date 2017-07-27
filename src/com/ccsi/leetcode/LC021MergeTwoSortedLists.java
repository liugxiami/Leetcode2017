package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/26.
 */
public class LC021MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(5);
        l1.next.next.next=new ListNode(9);
        l1.next.next.next.next=new ListNode(13);

        ListNode l2=new ListNode(2);
        l2.next=new ListNode(4);
        l2.next.next=new ListNode(8);

        ListNode result=mergeTwoLists(l1,l2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }

    }
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode dummyHead=new ListNode(0);
        ListNode temp=dummyHead;

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }

        if(l1!=null)temp.next=l1;
        if(l2!=null)temp.next=l2;

        return dummyHead.next;
    }
}
