package com.ccsi.leetcode1;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by gxliu on 2017/11/25.
 */
public class LC160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(2);

        ListNode b1=new ListNode(10);
        ListNode b2=new ListNode(20);
        ListNode b3=new ListNode(30);

        ListNode c1=new ListNode(5);
        ListNode c2=new ListNode(6);
        ListNode c3=new ListNode(7);

        a1.next=a2;
        a2.next=c1;

        b1.next=b2;
        b2.next=b3;
        b3.next=c1;

        c1.next=c2;
        c2.next=c3;

        ListNode result=getIntersectionNode1(a1,b1);
        if(result!=null) System.out.println(result.val);
    }
    //method1: 分别走一遍两个list，计算各自的长度，长度相减等到delta，让长的list先走delta步，再两个list同时走，如果
    //碰到相同的node，那么就是相交的node，否则就会一直走到底。
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null||headB==null)return null;
        int countA=0;
        int countB=0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=null){
            countA++;
            tempA=tempA.next;
        }
        while(tempB!=null){
            countB++;
            tempB=tempB.next;
        }

        int delta=Math.abs(countA-countB);
        if(countA>countB){
            while(delta-->0){
                headA=headA.next;
            }
        }else{
            while(delta-->0){
                headB=headB.next;
            }
        }

        while(headA!= headB){
            headA=headA.next;
            headB=headB.next;
        }

        return headA;
    }
    //method2：两list同时走，一旦一个list走到头了，就让这个list指向另外一个list的头，一直到两指针相同，循环结束条件是两
    //指针同时为null。因为相当于指针走了n+m步（listA的长度+listB的长度）。
    public static ListNode getIntersectionNode1(ListNode headA,ListNode headB){
        if(headA==null||headB==null)return null;
        ListNode listA=headA;
        ListNode listB=headB;

        while(true){
            if(listA==listB)return listA;
            listA=listA.next;
            listB=listB.next;

            if(listA==null&&listB==null)return null;
            if(listA==null)listA=headB;
            if(listB==null)listB=headA;
        }
    }
}
