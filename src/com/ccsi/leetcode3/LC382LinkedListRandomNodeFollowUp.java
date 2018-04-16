package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/15.
 * When we read the first node head, if the stream ListNode stops here, we can just
 * return the head.val. The possibility is 1/1.

 * When we read the second node, we can decide if we replace the result r or not.
 * The possibility is 1/2. So we just generate a random number between 0 and 1, and
 * check if it is equal to 1. If it is 1, replace r as the value of the current node,
 * otherwise we don’t touch r, so its value is still the value of head.

 * When we read the third node, now the result r is one of value in the head or second
 * node. We just decide if we replace the value of r as the value of current node(third
 * node). The possibility of replacing it is 1/3, namely the possibility of we don’t
 * touch r is 2/3. So we just generate a random number between 0 ~ 2, and if the result
 * is 2 we replace r.
 */
public class LC382LinkedListRandomNodeFollowUp {
    private ListNode head;
    Random ran;
    public LC382LinkedListRandomNodeFollowUp(ListNode head){
        this.head=head;
        ran=new Random();
    }
    public int getRandom(){
        ListNode curr=head;
        int result=head.val;
        int index=1;
        while(curr.next!=null){
            curr=curr.next;
            int random=ran.nextInt(index+1);
            if(random==index){
                result=curr.val;
            }
            index++;
        }
        return result;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LC382LinkedListRandomNodeFollowUp solution=new LC382LinkedListRandomNodeFollowUp(head);
        System.out.println(solution.getRandom());
    }
}
