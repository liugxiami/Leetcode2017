package com.ccsi.leetcode1;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Created by gxliu on 2017/11/19.
 */
public class LC147InsertionSortList {
    public static void main(String[] args) {
        ListNode head=buildListNode();
        head=insertionSortList(head);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    //用一个指针从前往后少，一旦碰到next比当前小，记住这个next，需要将这个next插入到前面排好序的list里面去，再来一个循环来比较
    // 并插入到刚好比这个next值大的节点前面。用一个dummyhead来做会更方便，比如插入到头节点时。
    public static ListNode insertionSortList(ListNode head){
        if(head==null||head.next==null)return head;//如果是空节点或只有一个元素，那么就不用排序了。
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode curr=head;
        while(curr.next!=null){     //从头到尾迭代
            if(curr.val<=curr.next.val){ //如果碰到next的value小于当前元素，那么这个next就是需要处理的。否则就往后走
                curr=curr.next;
            }else{
                ListNode willBeTreatedNode=curr.next;  //暂时保存这个要处理的node，并将其从原list上删除。
                curr.next=curr.next.next; //容易miss，因为这个willBeTreatedNode会被移到其他位置上去，那么需要先
                //将其从原来的位置上删除。

                ListNode temp=dummyHead; //再从头到尾迭代，一直到碰到正好比这个要处理的node大的这个节点。因为要插入到前
                // 面，所以一般找next，那么就是要插入到curr的后面。
                while(temp.next!=null&&temp.next.val<willBeTreatedNode.val){
                    temp=temp.next;
                }

                willBeTreatedNode.next=temp.next; //将这个node插入到。
                temp.next=willBeTreatedNode;
            }
        }
        return dummyHead.next;
    }
    //这是一个排序，但不是insertionSort，更像是bubbleSort，每次从头开始，看两相邻的，如果后面比前面小就交换。
    public static ListNode insertionSortList1(ListNode head){
        if(head==null||head.next==null)return head;
        boolean sorted=false;

        while(!sorted){
            ListNode curr=head;
            ListNode next=head.next;
            sorted=true;

            while(next!=null){
                if(curr.val>next.val){
                    swap(curr,next);
                    sorted=false;
                }
                curr=next;
                next=next.next;
            }
        }
        return head;
    }
    private static void swap(ListNode curr,ListNode next){
        int currValue=curr.val;
        curr.val=next.val;
        next.val=currValue;
    }
    private static ListNode buildListNode(){
        ListNode root=new ListNode(5);
        root.next=new ListNode(2);
        root.next.next=new ListNode(3);
        root.next.next.next=new ListNode(4);
        root.next.next.next.next=new ListNode(1);
        return root;
    }
}
