package com.ccsi.leetcode5;

import java.util.*;

public class LC581ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums={2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray1(nums));
    }
    public static int findUnsortedSubarray(int[] nums){
        if(nums==null||nums.length<2)return 0;
        int[] helper=nums.clone();
        Arrays.sort(helper);
        int p=0,q=nums.length-1;
        while(p<nums.length&&helper[p]==nums[p])p++;
        while(q>=0&&helper[q]==nums[q])q--;
        if(p>=q)return 0;
        return q-p+1;
    }
    //双指针，从beg到end是需要sort的subarray。
    public static int findUnsortedSubarray1(int[] nums){
        int beg=-1,end=-2,len=nums.length,max=nums[0],min=nums[len-1];
        for (int i = 1; i < len; i++) {
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[len-1-i]);
            if(max>nums[i])end=i; //从前往后走，如果当前的数小于前面的最大值，那么在这之前的都要重排
            if(min<nums[len-1-i])beg=len-1-i; //从后往前走，如果当前的数大于后面的最小值，那么这之后的也都要重排
        }
        return end-beg+1; //需要重排的前后位置都找到之后，注意是闭合区间。如果是排好序的递增数列，那么
        //end和beg都没变，那就是0，为了方便，在初始化时就直接初始化好为beg为-1，end为-2。
    }
}
