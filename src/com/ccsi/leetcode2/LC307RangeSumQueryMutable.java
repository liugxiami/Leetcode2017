package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/19.
 */
public class LC307RangeSumQueryMutable {
    private class Node {
        int sum;
        int from;
        int to;
        Node left;
        Node right;

        public Node(int sum, int from, int to) {
            this.sum = sum;
            this.from = from;
            this.to = to;
            this.left=null;
            this.right=null;
        }

        public Node(int from, int to){
            this.sum=0;
            this.from=from;
            this.to=to;
            this.left=null;
            this.right=null;
        }
    }
    private Node root;
    private int[] numbers;
    public LC307RangeSumQueryMutable(int[] nums) {
        if(nums==null||nums.length==0)root=null;
        int len=nums.length;
        root=buildTree(nums,0,len-1);
        numbers=nums;
    }
    //递归来建树
    private Node buildTree(int[] nums, int from, int to){
        if(from==to)return new Node(nums[from],from,to);

        Node curr=new Node(from,to);
        int mid=(to-from)/2+from;
        curr.left=buildTree(nums,from,mid);
        curr.right=buildTree(nums,mid+1,to);
        curr.sum=curr.left.sum+curr.right.sum;

        return curr;
    }
    //那么update时也用递归来做，不容易出错
    public void update(int i,int val){
        if(i<0||i>=numbers.length||numbers[i]==val)return;
        int delta=val-numbers[i];
        insert(i,delta,root);
    }
    private void insert(int i, int delta, Node curr){
        if(curr.from==curr.to){
            curr.sum+=delta;
            return;
        }
        curr.sum+=delta;
        int mid=(curr.to-curr.from)/2+curr.from;
        if(i<=mid) insert(i,delta,curr.left);
        else insert(i,delta,curr.right);
    }

    public int sumRange(int i,int j){
        if(i<0||j>numbers.length-1)return Integer.MIN_VALUE;
        return getSum(i,j,root);
    }
    private int getSum(int i,int j,Node curr){
        if(i==curr.from&&j==curr.to)return curr.sum;

        int mid=(curr.to-curr.from)/2+curr.to;
        if(i<mid&&j<mid)return getSum(i,j,curr.left);
        else if(i>mid&&j>mid)return getSum(i,j,curr.right);
        else return getSum(i,mid,curr.left)+getSum(mid+1,j,curr.right);
    }

    public static void main(String[] args) {
        int[] nums={1,3,5};
        LC307RangeSumQueryMutable sum=new LC307RangeSumQueryMutable(nums);
        System.out.println(sum.sumRange(0,2));
        sum.update(1,10);
        System.out.println(sum.sumRange(0,2));
    }
}
