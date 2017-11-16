package com.ccsi.leetcode1;


/**
 * Created by gxliu on 2017/11/15.
 */
public class LC141LinkedListCycle {
    public static void main(String[] args) {
        ListNode head=buildList();
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head){
        if(head==null||head.next==null)return false;

        ListNode slow=head;
        ListNode fast=head.next;   //slow和fast的起步不能一样，否则在下面判断时，第一步返回true。

        while(fast!=null&&fast.next!=null){
            if(slow==fast)return true;
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }

    public static boolean hasCycle1(ListNode head){
        if(head==null||head.next==null)return false;

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)return true; //如果两指针同步开始，那么判断放到后面就可以了。
        }
        return false;
    }
    public static ListNode buildList(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);

        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        //l6.next=l3;

        return l1;
    }
}
