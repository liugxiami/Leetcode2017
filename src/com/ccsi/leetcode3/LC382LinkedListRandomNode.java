package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/15.
 * with extra space
 */
public class LC382LinkedListRandomNode {
    private Map<Integer,ListNode> map;
    private int index;
    public LC382LinkedListRandomNode(ListNode head){
        this.map=new HashMap<>();
        index=0;
        while(head!=null){
            map.put(index,head);
            index++;
            head=head.next;
        }
    }
    public int getRandom(){
        if(map.isEmpty())return -1;
        if(map.size()==1)return map.get(0).val;

        int ran=new Random().nextInt(index);
        return map.get(ran).val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LC382LinkedListRandomNode solution=new LC382LinkedListRandomNode(head);
        System.out.println(solution.getRandom());
    }
}
