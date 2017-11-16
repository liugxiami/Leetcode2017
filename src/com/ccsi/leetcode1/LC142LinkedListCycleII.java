package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/15.
 */
public class LC142LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head=LC141LinkedListCycle.buildList();
        ListNode res=detectCycle1(head);
        System.out.println(res==null?"null":res.val);
    }
    //method1 在上题判断有无环的基础上改进，下面这种写法更好理解。
    public static ListNode detectCycle(ListNode head){
        if(head==null||head.next==null)return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)break;
        }

        if(fast==null||fast.next==null)return null;

        fast=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    //method2，对上面的方法进行缩减代码，其实是一样的，不一样的地方是在在while循环里面去寻找entry位点。
    public static ListNode detectCycle1(ListNode head){
        if(head==null||head.next==null)return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){    //碰到了说明有环，那就在声明一个新的entry变量从head开始。
                ListNode entry=head;
                while(slow!=entry){  //slow则从meeting位置开始，同步走，下次碰到的位置就是环开始的位置。
                    slow=slow.next;
                    entry=entry.next;
                }
                return entry;
            }
        }

        return null;
    }
}
