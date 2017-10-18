package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/16.
 */
public class LC092ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode res=reverseBetween1(head,2,4);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    //method1,借助一个index来来判断到了m和n位置没，没到m就一直move，到了m但还没到n就反转，到n就处理前后指针，结束。
    public static ListNode reverseBetween (ListNode head,int m,int n){
        if(head==null||head.next==null)return head;
        int index=0;

        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;

        ListNode pre=dummyHead;
        ListNode curr=head;
        ListNode next=head.next;

        while(curr!=null){
            index++;
            if(index<m){
                pre=curr;
                curr=next;
                next=next.next;
            }else if(index>=m&&index<n){
                ListNode temp=next.next;
                next.next=curr;
                curr=next;
                next=temp;
            }else if(index==n){
                ListNode temp=pre.next;
                pre.next=curr;
                temp.next=next;
                break;
            }
        }
        return dummyHead.next;
    }
    //method2,先走到m前一个，之后开始翻转n-m次，最后处理前后指针
    public static ListNode reverseBetween1(ListNode head,int m,int n){
        if(head==null||head.next==null)return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        head=dummyHead;

        int count=m-1;
        while(count-->0){
            head=head.next;
        }

        int flips=n-m;
        ListNode curr=head.next;
        ListNode next=curr.next;
        while(flips-->0){
            ListNode temp=next.next;
            next.next=curr;
            curr=next;
            next=temp;
        }

        ListNode t=head.next;
        head.next=curr;
        t.next=next;

        return dummyHead.next;
    }
}
