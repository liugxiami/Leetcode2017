package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/24.
 */
public class LC153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(findMin1(nums));
    }
    //method1.
    public static int findMin(int[] nums){
        if(nums==null||nums.length==0)return -1;
        int len=nums.length;
        return find(nums,0,len-1);
    }
    private static int find(int[] nums,int start,int end){
        if(start==end)return nums[start];

        int mid=start+(end-start)/2;
        if(nums[mid]<nums[end])return find(nums,start,mid); //后半段是排好序的，那必定找前半段。
        else return find(nums,mid+1,end);
    }
    //method2 loop
    public static int findMin1(int[] nums){
        if(nums==null||nums.length==1)return -1;
        int len=nums.length;
        int start=0;
        int end=len-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<nums[end])end=mid;
            else start=mid+1;
        }
        return nums[start];
    }
}
