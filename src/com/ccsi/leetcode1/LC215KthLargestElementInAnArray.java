package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/12.
 */
public class LC215KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums={3,2,1,5,6,4};
        System.out.println(findKthLargest2(nums,2));
    }
    //method1 Arrays.sort(); O(nlgn)
    public static int findKthLargest(int[] nums,int k){
        if(nums==null||nums.length==0||k<=0||k>nums.length)return 0;
        Arrays.sort(nums);

        return nums[nums.length-k];
    }
    //method2 PriorityQueue
    public static int findKthLargest1(int[] nums,int k){
        if(nums==null||nums.length==0||k<=0||k>nums.length)return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(100, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }

        int count=k-1;
        while(count-->0)pq.poll();
        return pq.peek();
    }
    //method3 利用quickSort的partition方法
    public static int findKthLargest2(int[] nums,int k){
        if(nums==null||nums.length==0||k<=0||k>nums.length)return 0;
        int len=nums.length;
        int start=0;
        int end=len-1;
        k=k-1;//转换成数组的index。
        while(start<end){
            int pi=partion(nums,start,end);
            if(k==pi)return nums[k];
            else if(k<pi)end=pi-1;
            else start=pi+1;
        }
        return nums[start];
    }
    //这个partition给nums排序是从大到小。
    private static int partion(int[] nums,int start,int end){
        if(start==end)return start;
        int ran=new Random().nextInt(end-start)+start;
        swap(nums,start,ran);
        int pivot=nums[start];
        int left=start;
        int right=end+1;
        while(true){
            while (++left<end&&nums[left]>pivot);
            while(--right>start&&nums[right]<pivot);
            if(left<right)swap(nums,left,right);
            else break;
        }
        swap(nums,start,right);
        return right;
    }
    private static void swap(int[] nums,int p,int q){
        if(p==q)return;
        int temp=nums[p];
        nums[p]=nums[q];
        nums[q]=temp;
    }
}
