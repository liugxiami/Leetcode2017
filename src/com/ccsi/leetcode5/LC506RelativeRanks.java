package com.ccsi.leetcode5;

import java.util.PriorityQueue;

public class LC506RelativeRanks {
    public static void main(String[] args) {
        int[] nums={5,3};
        String[] result=findRelativeRanks(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static String[] findRelativeRanks(int[] nums){
        if(nums==null||nums.length==0)return new String[0];
        int len=nums.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for (int i = 0; i < len; i++) {
            pq.offer(new int[]{nums[i],i});
        }

        String[] result=new String[len];
        for (int i = 0; i < len; i++) {
            int[] curr=pq.poll();
            if(i==0)result[curr[1]]="Gold Medal";
            else if(i==1)result[curr[1]]="Silver Medal";
            else if(i==2)result[curr[1]]="Bronze Medal";
            else result[curr[1]]=String.valueOf(i+1);
        }
        return result;
    }
}
