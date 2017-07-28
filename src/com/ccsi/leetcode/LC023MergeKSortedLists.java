package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/27.
 */
public class LC023MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists=new ListNode[3];
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(5);
        l1.next.next.next=new ListNode(9);
        l1.next.next.next.next=new ListNode(13);

        ListNode l2=new ListNode(2);
        l2.next=new ListNode(4);
        l2.next.next=new ListNode(8);

        ListNode l3=new ListNode(6);
        l3.next=new ListNode(11);
        l3.next.next=new ListNode(20);

        lists[0]=l1;
        lists[1]=l2;
        lists[2]=l3;

        ListNode res=mergeKLists(lists);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists==null||lists.length==0)return null;
        int len=lists.length;
        ListNode result=helper(lists,0,len-1);
        return result;
    }
    private static ListNode helper(ListNode[] lists,int start,int end){
        if(start==end)return lists[start];
        int mid=start+(end-start)/2;
        ListNode first=helper(lists,start,mid);
        ListNode second=helper(lists,mid+1,end);

        ListNode dummyHead=new ListNode(0);
        ListNode temp=dummyHead;
        while(first!=null&&second!=null){
            if(first.val<second.val){
                temp.next=first;
                first=first.next;
            }else{
                temp.next=second;
                second=second.next;
            }
            temp=temp.next;
        }

        if(first!=null)temp.next=first;
        if(second!=null)temp.next=second;
        return dummyHead.next;
    }
}
