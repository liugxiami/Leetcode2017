package com.ccsi.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gxliu on 2018/1/31.
 */
public class LC315CountOfSmallerNumberAfterSelfSegmentTree {
    public static void main(String[] args) {
        int[] nums={5,2,6,1};
        List<Integer> result=countSmaller(nums);
        result.forEach(x-> System.out.println(x));
    }
    public static class Node{
        int count;
        int start,end;
        Node left,right;

        public Node(int start,int end) {
            this.start=start;
            this.end=end;
            this.count = 0;
        }
    }
    public static Node root;
    public static List<Integer> countSmaller(int[] nums){
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        int len=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        root=buildSegmentTree(min,max);
        for (int i = len-1; i >=0 ; i--) {
            insert(nums[i],root);
            result.add(0,query(min,nums[i]-1,root));
        }
        return result;
    }
    //同buildBST
    private static Node buildSegmentTree(int li,int hi){
        if(li==hi)return new Node(li,hi);

        int mi=li+(hi-li)/2;
        Node curr=new Node(li,hi);
        curr.left=buildSegmentTree(li,mi);
        curr.right=buildSegmentTree(mi+1,hi);
        return curr;
    }
    private static void insert(int num,Node curr){
        if(curr.start==curr.end){
            curr.count+=1;
            return;
        }

        int li=curr.start;
        int hi=curr.end;

        int mi=li+(hi-li)/2;
        curr.count++;
        if(num<=mi){
            insert(num,curr.left);
        }else{
            insert(num,curr.right);
        }


    }

    private static int query(int li,int hi,Node curr){
        if(hi<li)return 0;

        if(curr.start==li&&curr.end==hi)return curr.count;
        int start=curr.start;
        int end=curr.end;
        int md=start+(end-start)/2;
        if(hi<=md)return query(li,hi,curr.left);
        else if(li>md)return query(li,hi,curr.right);
        else return query(li,md,curr.left)+query(md+1,hi,curr.right);
    }
}
