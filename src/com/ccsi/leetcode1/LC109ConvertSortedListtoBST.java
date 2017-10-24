package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/10/23.
 */
public class LC109ConvertSortedListtoBST {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next=new ListNode(7);

        TreeNode result=sortedListToBST1(head);

    }
    //method1 方法类似前面，每次都要找中间节点，时间复杂度（O（nlgn））比用数组（O（1））的慢了很多。
    public static TreeNode sortedListToBST(ListNode head){
        if(head==null)return null;
        ListNode secondHead=head;
        ListNode mid=head;
        ListNode pre=head; //需要一个pre将前半段给切断。

        while(secondHead!=null&&secondHead.next!=null){
            pre=mid;       //在mid的前面
            secondHead=secondHead.next.next;
            mid=mid.next;
        }

        secondHead=mid.next;
        TreeNode root=new TreeNode(mid.val);
        pre.next=null;  //切断

        root.left=(head!=mid)?sortedListToBST(head):null; //这里需要考虑head是否和mid相同，也就是只剩下
        //一个元素时，那么其子树必定为null。
        root.right=sortedListToBST(secondHead);

        return root;
    }
    //method2
    public static TreeNode sortedListToBST1(ListNode head){
        if(head==null)return null;
        return helper(head,null);
    }

    private static TreeNode helper(ListNode start,ListNode end){ //ListNode的开头到最后一个节点的下一个
        if(start==end)return null;

        ListNode fast=start;
        ListNode slow=start;

        while(fast!=end&&fast.next!=end){ //是不等于end，不是一般情况下的null
            fast=fast.next.next;
            slow=slow.next;  //在start和end之间找中间点
        }

        TreeNode root=new TreeNode(slow.val); //找到之后声明一个根节点
        root.left=helper(start,slow);  //递归生产左子树
        root.right=helper(slow.next,end); //递归生成右子树

        return root;
    }
}
