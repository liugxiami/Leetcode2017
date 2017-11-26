package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/25.
 */
public class LC154FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums={3,1,2,3,3,3,3};
        System.out.println(findMin1(nums));
    }
    //method1 loop
    //3 1 2 3 3 3 3与3 3 3 3 1 2 3case，如果nums[mid]==nums[end],以上两case区分不出是前半段找还是后半段找。这时就做
    //end--，因为即使这个end被去除了，那个最小值还是在，因为nums[mid]==nums[end]，至少与nums[end]一样大的nums[mid]还在
    public static int findMin(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;

        int start=0;
        int end=len-1;

        while(start+1<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<nums[end])end=mid;
            else if(nums[mid]>nums[end])start=mid+1;
            else end--;
        }
        //循环结束时剩下两个元素，nums[start]和nums[end],这是两个连续的元素。这时还要再判断一下大小。
        if(nums[start]<=nums[end])return nums[start];
        else return nums[end];
    }
    //method2 recursion
    public static int findMin1(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        return find(nums,0,len-1);
    }
    private static int find(int[] nums,int start,int end){
        if(start==end)return nums[start];

        int mid=start+(end-start)/2;
        if(nums[mid]<nums[end])return find(nums,start,mid);
        else if(nums[mid]>nums[end])return find(nums,mid+1,end);
        else return find(nums,start,end-1);
    }
}
