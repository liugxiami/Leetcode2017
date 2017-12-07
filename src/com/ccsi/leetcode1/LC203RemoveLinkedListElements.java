package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/12/6.
 */
public class LC203RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
//        head.next=new ListNode(2);
//        head.next.next=new ListNode(6);
//        head.next.next.next=new ListNode(3);
//        head.next.next.next.next=new ListNode(4);
//        head.next.next.next.next.next=new ListNode(5);
//        head.next.next.next.next.next.next=new ListNode(6);
        head.next=new ListNode(1);

        ListNode res=reomveElements(head,1);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode reomveElements(ListNode head,int val){
        if(head==null)return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode curr=dummyHead;
        while(curr!=null&&curr.next!=null){
            if(curr.next.val==val){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }

        }
        return dummyHead.next;
    }
}
