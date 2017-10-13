package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/12.
 */
public class LC082RemoveDuplicateFromSortedListII {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(1);
//        head.next.next=new ListNode(3);
//        head.next.next.next=new ListNode(3);
//        head.next.next.next.next=new ListNode(4);
//        head.next.next.next.next.next=new ListNode(4);
//        head.next.next.next.next.next.next=new ListNode(5);
        ListNode res=deleteDuplicates(head);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        //需要三个指针，指向当前和next各一个，这两个的val需要被比较，因为如果相同，这个两个会被删除，那么还需要一个指针来保存前
        //一个节点。
        ListNode pre=dummyHead;
        ListNode curr=head;
        ListNode next=head.next;
        //有重复和没重复时，指针的挪动动作是不一样的，为了方便，在定义一个hasDuplicate的变量。
        boolean hasDuplice=false;

        while(next!=null){
            if(curr.val==next.val){  //如果有重复节点，那么标记一下，next往后走，说不定还有重复的。
                hasDuplice=true;
                next=next.next;
                if(next==null){      //这步一定要注意，如果是结尾处有重复，直接将pre.next=null，否则不能被删掉。或者用
                    //do...while循环。
                    pre.next=null;
                }
            }else{                    //否则
                if(hasDuplice){       //如果前面有重复，那么pre.next直接指向这个next节点，中间几个就被删掉了。curr指向next，
                    //next指向next.next （和后面的代码有重复，就写到后面一块去了）
                    pre.next=next;
                    hasDuplice=false;  //将hasDuplicate恢复。
                }else{
                    pre=curr;          //没有重复的话，那么三个指针都往后挪一位
                }
                curr=next;
                next=next.next;
            }
        }
        return dummyHead.next;
    }
}
