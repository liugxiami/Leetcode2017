package com.ccsi.leetcode2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by gxliu on 2017/12/26.
 */
public class LC239SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums={1,3,-1,1,-3,2,5,3,6,7};
        int[] result=maxSlidingWindow(nums,3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    //借用一个priorityQueue，里面是排好序的，peek就是最值，如果长度等于k，就remove 数组中i-k+位置上的的那个数。
    public static int[] maxSlidingWindow(int[] nums,int k){
        if(nums==null||nums.length==0||k<1)return new int[0];
        int len=nums.length;
        if(k>len)k=len;
        int newLen=len-k+1;
        int[] result=new int[newLen];

        PriorityQueue<Integer> pq=new PriorityQueue<>(newLen, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < len; i++) {
            pq.offer(nums[i]);
            if(pq.size()>=k){
                result[i-k+1]=pq.peek();
                pq.remove(nums[i-k+1]);
            }
        }
        return result;
    }
}
