package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/30.
 */
public class LC025ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(5);
        l1.next.next.next=new ListNode(9);
        l1.next.next.next.next=new ListNode(13);
        ListNode res=reverseKGroup(l1,3);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head,int k){
        if(head==null||k<=1)return head;
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        head=dummyhead;

        while(head.next!=null){
            //从head开始的（其实是要逆反的k个节点的前一个节点开始传入函数）
            head=reverseK(head,k);
        }
        return dummyhead.next;
    }
    //该辅助函数是从要逆反的k个节点的前一个节点开始，为了更好的处理k个节点系列的前后节点
    private static ListNode reverseK(ListNode head,int k){
        ListNode nHead=head;
        //先要看看是否需要逆转，要的条件就是有还剩k个节点，考虑到头一个节点不算，所以判断head.next
        for (int i = 0; i < k; i++) {
            if(nHead.next==null)return nHead;
            nHead=nHead.next;
        }

        ListNode n1=head.next; //第一个节点是head.next；
        //做逆转时需要3个指针，一个是当前curr，一个是前一个node pre，另外一个是next
        ListNode pre=head,curr=n1;
        for (int i = 0; i < k; i++) {
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }
        //此时的curr是下一个k节点的第一个node
        //pre是当前k节点的第一个node，也是前k个节点的最后一个指向的node
        //因此，尾处理时需要将head.next指向pre；n1.next执行curr，比返回n1；
        n1.next=curr; //此时的n1就是当前k个节点的最后一个节点了，所以要n1.next指向下一个k个节点的第一个节点。
        head.next=pre;//head是前k个节点的最后一个节点
        return n1;

    }
}
