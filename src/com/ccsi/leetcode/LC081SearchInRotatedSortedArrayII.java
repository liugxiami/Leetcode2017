package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/12.
 */
public class LC081SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums={3,1,1};
        System.out.println(search(nums,3));
    }
    public static boolean search(int[] nums,int target){
        if(nums==null||nums.length==0)return false;
        int start=0,end=nums.length-1;
        int index=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                index=mid;
                break;   //必须有这个break，否则会出现无限循环
            }
            else if(nums[start]<nums[mid]){  //左半部是排好序的
                if(target>=nums[start]&&target<nums[mid])end=mid-1; //如果target在左半部那么end=mid-1，注意：>=
                else start=mid+1;                                   //否则在右半部找
            }else if(nums[start]>nums[mid]){ //右半部四排好序的
                if(target>nums[mid]&&target<=nums[end])start=mid+1;  //如果target在右半部那么start=mid+1，注意：<=
                else end=mid-1;                                      //否则在左半部找
            }else start++;                                           //因为有重复的数值在，那么可能出现
            //nums[start]=nums[mid]的情况，这样的话就start++；
        }
        return index!=-1;
    }
}
