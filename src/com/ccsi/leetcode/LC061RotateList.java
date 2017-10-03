package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/2.
 */
public class LC061RotateList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode res=rotateRight(head,5);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }

    }
    public static ListNode rotateRight(ListNode head,int k){
        if(head==null||head.next==null)return head;

        int size=0;         //获得list的size大小
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }

        k%=size;               //如果k比较大，大于整个list的size，那么做取余

        if(k==0)return head;

        head=reverse(head);   //reverse全list
        ListNode secondHead=head,firstHead=head;

        while(k-->1){  //走到第二个head节点的前一个
            head=head.next;
        }

        secondHead=head.next; //找到第二个head
        head.next=null;       //断了第一个head的尾巴
        firstHead=reverse(firstHead); //revers第一个head
        secondHead=reverse(secondHead); //reverse第二个head

        head=firstHead;
        while(head!=null&&head.next!=null){    //迭代到第一个head的尾巴
            head=head.next;

        }

        head.next=secondHead;     //第一个head的尾巴指向第二个head的头
        return firstHead;         //返回第一个head
    }
    private static ListNode reverse(ListNode head){  //reverseList的经典做法。
        if(head==null||head.next==null)return head;
        ListNode pre=head;
        ListNode curr=head.next;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        head.next=null;
        head=pre;
        return head;
    }
}
