package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/15.
 */
public class LC143ReorderList {
    public static void main(String[] args) {
        ListNode head=LC141LinkedListCycle.buildList();
        reorderList1(head);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    //method1，需要一个辅助函数，对一个链表进行反序。在主函数中，写一个循环，每个循环往后走一步，同时对指针后面的链表
    // 进行反序，直到结束。进行反序的次数太多了，是n！，时间复杂度太高了 O（n！），其中n是链表的长度。
    public static void reorderList(ListNode head){
        if(head==null||head.next==null)return;
        ListNode curr=head;
        while(curr!=null&&curr.next!=null){
            ListNode newList=reverse(curr.next);
            curr.next=newList;
            curr=curr.next;
        }
    }
    private static ListNode reverse(ListNode root){
        if(root==null||root.next==null)return root;
        ListNode pre=root;
        ListNode curr=root.next;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        root.next=null;
        root=pre;
        return root;
    }
    //method2 也需要对链表进行反序，需要这个函数但指向反序一次，先找到中点，然后对中点后的链表反序，再用两个指针，一个
    //从head开始，一个从mid的后一个开始，交替将两节点放到一个新的链表上去。更容易的方法就是从mid后面中断成两链表，
    //再写一个merge函数。
    public static void reorderList1(ListNode head){
        if(head==null||head.next==null)return;
        ListNode mid=findMid(head);
        ListNode rightList=reverse1(mid.next);
        mid.next=null;
        merge(head,rightList);
    }
    private static ListNode findMid(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static ListNode reverse1(ListNode head){
        ListNode newHead=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=newHead;
            newHead=head;
            head=next;
        }
        return newHead;
    }
    private static void merge(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(0);

        int count=1;
        while(head1!=null&&head2!=null){
            if(count%2==1){
                dummy.next=head1;
                head1=head1.next;
            }else{
                dummy.next=head2;
                head2=head2.next;
            }
            dummy=dummy.next;
            count++;
        }
        if(head1!=null){
            dummy.next=head1;
        }else{
            dummy.next=head2;
        }
    }
}
