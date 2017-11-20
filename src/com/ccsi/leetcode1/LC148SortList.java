package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/19.
 */
public class LC148SortList {
    public static void main(String[] args) {
        ListNode head=buildListNode();
        ListNode res=sortList(head);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    //mergeSort的方法
    public static ListNode sortList(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode mid=findMid(head);

        ListNode rightHalf=mid.next;
        mid.next=null;
        ListNode leftHalf=head;

        ListNode left=sortList(leftHalf);
        ListNode right=sortList(rightHalf);

        ListNode root=merge(left,right);
        return root;
    }
    private static ListNode merge(ListNode left,ListNode right){
        ListNode dummyHead=new ListNode(0);
        ListNode curr=dummyHead;
        while(left!=null&&right!=null){
            if(left.val<right.val){
                curr.next=left;
                left=left.next;
            }else{
                curr.next=right;
                right=right.next;
            }
            curr=curr.next;
        }
        if(left!=null){
            curr.next=left;
        }else{
            curr.next=right;
        }
        return dummyHead.next;
    }

    private static ListNode findMid(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private static ListNode buildListNode(){
        ListNode root=new ListNode(5);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);
        root.next.next.next.next=new ListNode(1);
        return root;
    }
}
