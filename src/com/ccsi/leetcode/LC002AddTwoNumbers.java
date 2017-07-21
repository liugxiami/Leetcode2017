package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/11.
 */
public class LC002AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(5);
        l1.next.next.next=new ListNode(8);
        l1.next.next.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        ListNode result=addTwoNumbers(l1,l2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummyHead=new ListNode(0);
        ListNode curr=dummyHead;
        int flag=0;
        while(l1!=null&&l2!=null){
            int temp=flag+l1.val+l2.val;
            flag=temp/10;
            temp%=10;
            curr.next=new ListNode(temp);
            curr=curr.next;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            int temp=flag+l1.val;
            flag=temp/10;
            temp%=10;
            curr.next=new ListNode(temp);
            curr=curr.next;
            if(flag==0){
                curr.next=l1.next;
                break;
            }else{
                l1=l1.next;
            }

        }

        while(l2!=null){
            int temp=flag+l2.val;
            flag=temp/10;
            temp%=10;
            curr.next=new ListNode(temp);
            curr=curr.next;
            if(flag==0){
                curr.next=l2.next;
                break;
            }else{
                l2=l2.next;
            }

        }



        if(flag==1){
            curr.next=new ListNode(1);
            curr=curr.next;
        }
        return dummyHead.next;
    }
}
