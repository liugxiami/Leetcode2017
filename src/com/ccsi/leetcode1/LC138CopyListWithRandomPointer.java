package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/14.
 */
public class LC138CopyListWithRandomPointer {
    public static void main(String[] args) {
        RandomListNode head=build();
        RandomListNode newHead=copyRandomList(head);
    }
    public static RandomListNode copyRandomList(RandomListNode head){
        if(head==null)return null;

        RandomListNode newHead=new RandomListNode(head.label);
        RandomListNode root=newHead;

        Map<Integer,RandomListNode> map=new HashMap<>(); //关键步骤，用一个map来保存已在新list中出现过的节点。
        map.put(head.label,newHead);

        while(head!=null){
            if(head.next!=null){
                if(!map.containsKey(head.next.label)){  //如果没出现过就新生成一个
                    newHead.next=new RandomListNode(head.next.label);
                    map.put(head.next.label,newHead.next);
                }else{
                    newHead.next=map.get(head.next.label); //出现过，就到map里面去找出来。
                }
            }

            if(head.random!=null){
                if(!map.containsKey(head.random.label)){
                    newHead.random=new RandomListNode(head.random.label);
                    map.put(head.random.label,newHead.random);
                }else{
                    newHead.random=map.get(head.random.label);
                }
            }

            head=head.next;
            newHead = newHead.next;
        }

        return root;
    }

    public static RandomListNode build(){
        RandomListNode r1=new RandomListNode(1);
        RandomListNode r2=new RandomListNode(2);
        RandomListNode r3=new RandomListNode(3);
        RandomListNode r4=new RandomListNode(4);
        RandomListNode r5=new RandomListNode(5);

        r1.next=r2;
        r2.next=r3;
        r3.next=r4;
        r4.next=r5;

        r2.random=r4;
        r4.random=r3;

        return r1;
    }
}
