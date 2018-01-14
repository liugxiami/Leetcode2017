package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/14.
 */
public class LC303RangeSumQuery {
    private int[] sums;
    public LC303RangeSumQuery(int[] nums){
        if(nums==null||nums.length==0)return;
        int len=nums.length;
        sums=new int[len];
        sums[0]=nums[0];
        for (int i = 1; i < len; i++) {
            sums[i]=sums[i-1]+nums[i];
        }
    }

    public int sumRange(int i,int j){
        if(i<0||i>j||j>=sums.length)return Integer.MIN_VALUE;
        return i==0?sums[j]:sums[j]-sums[i-1];
    }

    public static void main(String[] args) {
        int[] nums={-2, 0, 3, -5, 2, -1};
        LC303RangeSumQuery range=new LC303RangeSumQuery(nums);
        int result=range.sumRange(0,5);
        System.out.println(result);
    }
}
