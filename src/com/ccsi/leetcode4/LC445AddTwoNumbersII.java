package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/7/17.
 */
public class LC445AddTwoNumbersII {
    public static void main(String[] args) {
        int[] arr1={7,2,4,3};
        int[] arr2={5,6,4};
        ListNode l1=makeList(arr1);
        ListNode l2=makeList(arr2);
        ListNode res=addTwoNumbers1(l1,l2);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    private static ListNode makeList(int[] array){
        ListNode res=new ListNode(0);
        ListNode curr=res;
        for(int i=0;i<array.length;i++){
            curr.val=array[i];
            if(i!=array.length-1){
                curr.next=new ListNode(0);
                curr=curr.next;
            }
        }
        return res;
    }
    //method1: 先进行reverse List，如何依次相加，注意进位。
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode result=new ListNode(0);
        l1=reverseList(l1);
        l2=reverseList(l2);
        ListNode curr=result;
        while(l1!=null&&l2!=null){
            int temp=curr.val+l1.val+l2.val;
            curr.val=temp%10;
            curr.next=new ListNode(temp/10);//之间将flag放进curr.val里面去
            l1=l1.next;
            l2=l2.next;
            curr=curr.next;
        }
        ListNode remain=l1==null?l2:l1;
        while(remain!=null){
            int temp=curr.val+remain.val;
            curr.val=temp%10;
            curr.next=new ListNode(temp/10);
            remain=remain.next;
            curr=curr.next;
        }
        ListNode res=reverseList(result);
        return res.val==0?res.next:res;
    }
    private static ListNode reverseList(ListNode list){
        if(list==null||list.next==null)return list;
        ListNode pre=list;
        ListNode curr=list.next;
        pre.next=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
    //method2:借用stack
    public static ListNode addTwoNumbers1(ListNode l1,ListNode l2) {
        ListNode list = new ListNode(0);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) list.val += stack1.pop();
            if (!stack2.isEmpty()) list.val += stack2.pop();
            ListNode head = new ListNode(list.val / 10); //这个list从后往前增长。
            list.val %= 10;
            head.next = list;
            list = head;
        }
        return list.val == 0 ? list.next : list; //返回是要判断一下最开头是否为0，因为前面的进位有可能是0.
    }
}
