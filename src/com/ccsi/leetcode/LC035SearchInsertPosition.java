package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/11.
 */
public class LC035SearchInsertPosition {
    public static int searchInsert(int[] nums,int target){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        //if(target<nums[0])return 0;
        //if(target>nums[len-1])return len;
        int left=0,right=len-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target)return mid;
            if(target<nums[mid])right=mid-1;
            else left=mid+1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums={1,3,5,9};
        System.out.println(searchInsert(nums,10));
    }
}
