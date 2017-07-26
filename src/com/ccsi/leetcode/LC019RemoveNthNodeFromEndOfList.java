package com.ccsi.leetcode;

import java.util.HashMap;

/**
 * Created by gxliu on 2017/7/25.
 */
public class LC019RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode result=removeNthFromEnd1(head,2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    //method1 结果是对的，但是用了额外的空间。
    public static ListNode removeNthFromEnd(ListNode head,int n){
        if(head==null||n<0)return null;
        if(n==0)return head;
        HashMap<Integer,ListNode> map=new HashMap<>();
        int index=0;
        ListNode temp=head;
        while(head!=null){
            map.put(index,head);
            head=head.next;
            index++;
        }
        //注意，此时的index其实+1了，它现在等于list的长度。
        if(index<n){
             return temp;
        }else if(index==n){
            return temp.next;
        }else{
            int delta=index-n;
            ListNode curr=map.get(delta-1); //
            if(delta==0)return curr.next=null;
            else{
                curr.next=curr.next.next;
            }
            return temp;
        }
    }
    //method2 利用链表的双指针，第一个指针走n步，然后前后指针同时走到底，因为是删除倒数第n个node，所以后一个指针其实要前一个node
    //然后用这个node的next执行其next.next就可以了。因此还是用一个dummyhead好。
    public static ListNode removeNthFromEnd1(ListNode head,int n){
        if(head==null||n<=0)return null;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;

        ListNode deleteList=dummyHead;
        for (int i = 0; i < n; i++) {
            if(head==null)return null;
            head=head.next;
        }

        while(head!=null){
            head=head.next;
            deleteList=deleteList.next;
        }

        deleteList.next=deleteList.next.next;
        return dummyHead.next;
    }
}
