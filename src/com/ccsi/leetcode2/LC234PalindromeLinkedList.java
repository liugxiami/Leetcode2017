package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/22.
 */
public class LC234PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(3);
//        head.next.next.next.next=new ListNode(2);
//        head.next.next.next.next.next=new ListNode(1);

        System.out.println(isPalindrome2(head));
    }
    //method1：reverse这个list，再比较新旧两list是否一样，一样的话就是palindrome，否则就不是。
    public static boolean isPalindrome(ListNode head){
        if(head==null||head.next==null)return true;
        ListNode newHead=reverse(head);
        while(head!=null){
            if(head.val!=newHead.val)return false;
            head=head.next;
            newHead=newHead.next;
        }
        return true;
    }
    private static ListNode reverse(ListNode head){
        ListNode newHead=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=newHead;
            newHead=curr;
            curr=next;
        }
        return newHead;
    }
    //method2：快慢指针载加上一个stack。
    public static boolean isPalindrome1(ListNode head){
        if(head==null||head.next==null)return true;
        ListNode slow=head;
        ListNode fast=head; //都从head开始
        Stack<Integer> stack=new Stack<>();
        stack.push(head.val);

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            stack.push(slow.val); //stack将slow已经指到的值都push进行，方便理解和操作。
        }
        if(fast==null)stack.pop(); //关系到是偶数还是奇数对称问题，如果是奇数，slow走到中点时，fast还没走出去了。

        ListNode newStart=slow; //这时的slow就是中点，如果是奇数个的话，纯中点（fast指向最后一个）。偶数个的话，slow指向后半段
        //的第一个，fast已经指到外面去了。因为stack中存的数包括了最后指向的slow，这时要将最后一个pop出去，此时倒数第一和第二个
        //数是相同的。
        while(newStart!=null){
            if(!stack.isEmpty()&&newStart.val!=stack.pop())return false;
            newStart = newStart.next;
        }
        return true;
    }
    //上面两种方法都使用了额外的空间，如果使得空间复杂度为O（1）呢？结合快慢指针和reverse方法，将后半段直接反转在比较就好了
    public static boolean isPalindrome2(ListNode head){
        if(head==null||head.next==null)return true;
        ListNode slow=head;
        ListNode fast=head.next;
        //先找到中点
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //将中点之后的list逆转，并接到原来的序列后面，这里还是用辅助函数方便，直接写容易出错。
        ListNode rightHalf=slow.next;
        //slow.next=null;
        slow.next=reverse(rightHalf);
        slow=slow.next;
        //从头开始与逆转的序列进行比较。
        while(slow!=null){
            if(head.val!=slow.val)return false;
            head=head.next;
            slow=slow.next;
        }
        return true;

    }
}
