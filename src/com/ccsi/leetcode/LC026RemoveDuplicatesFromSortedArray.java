package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/31.
 */
public class LC026RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums={1,1,2,2,3,3,3,4};
        System.out.println(removeDumplicates(nums));
    }

    public static int removeDumplicates(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int fast=0,slow=0;
        int len=nums.length;
        while(fast<len){
            if(nums[fast]!=nums[slow]){
                nums[++slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
