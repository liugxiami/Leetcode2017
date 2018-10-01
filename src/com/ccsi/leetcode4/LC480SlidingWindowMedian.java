package com.ccsi.leetcode4;

import java.util.*;

public class LC480SlidingWindowMedian {
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        double[] res=medianSlidingWindow(nums,3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    //Heap
    public static double[] medianSlidingWindow(int[] nums,int k) {
        if (nums == null || nums.length < k) return null;
        int len = nums.length;
        double[] results = new double[len - k + 1];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder()); //first half
        //PriorityQueue<Integer> maxQueue=new PriorityQueue<>((a,b)->b-a); //结果不对
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); //second half
        for (int i = 0; i < len; i++) {
            maxQueue.offer(nums[i]);
            minQueue.offer(maxQueue.poll());
            if (maxQueue.size() < minQueue.size()) {
                maxQueue.offer(minQueue.poll());
            }
            if (maxQueue.size() + minQueue.size() == k) {
                double temp_res = 0;
                if (maxQueue.size() != minQueue.size()) {
                    temp_res = (double) (maxQueue.peek());
                } else {
                    temp_res = (double)((long) (maxQueue.peek()) + (long) (minQueue.peek())) / 2;
                }

                int loci = i - k + 1;
                results[loci] = temp_res;

                if (!maxQueue.remove(nums[loci])) minQueue.remove(nums[loci]);
            }
        }
        return results;
    }
}
