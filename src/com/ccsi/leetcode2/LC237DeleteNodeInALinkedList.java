package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/23.
 */
public class LC237DeleteNodeInALinkedList {
    public static void main(String[] args) {

    }
    public static void deleteNode(ListNode node){
        if(node==null)return;
        if(node.next==null)node=null;
        else {
            node.val=node.next.val;
            node.next=node.next.next;
        }
    }
}
