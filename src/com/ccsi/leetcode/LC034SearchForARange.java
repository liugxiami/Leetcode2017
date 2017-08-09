package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/8/8.
 */
public class LC034SearchForARange {
    public static void main(String[] args) {
        int[] array={5,7,7,8,8,10};
        int[] result=searchRange(array,6);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    //method 1:loop
    public static int[] searchRange(int[] nums,int target){
        int[] result={-1,-1};
        if(nums==null||nums.length==0)return result;

        int len=nums.length;

        if(target<nums[0]||target>nums[len-1])return result;

        //find left index
        int left=0,right=len-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target<=nums[mid])right=mid-1;
            else left=mid+1;
        }

        if(left>=len||nums[left]!=target)return result;
        result[0]=left;
        //find right index
        left=0;
        right=len-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(target>=nums[mid])left=mid+1;
            else right=mid-1;
        }
        result[1]=right;
        return result;
    }

    //method 2:recursion
    public static int[] searchRange1(int[] nums,int target){
        int[] result={-1,-1};
        if(nums==null||nums.length==0)return result;
        int len=nums.length;
        if(target>nums[len-1]||target<nums[0])return result;

        result[0]=findLeftIndex(nums,0,len-1,target);
        result[1]=findRightIndex(nums,0,len-1,target);
        return result;
    }
    private static int findLeftIndex(int[] nums,int start,int end,int target){
        if(start>end)return start<nums.length&&nums[start]==target?start:-1;
        int mid=start+(end-start)/2;
        if(target<=nums[mid])return findLeftIndex(nums,start,mid-1,target);
        else return findLeftIndex(nums,mid+1,end,target);
    }

    private static int findRightIndex(int[] nums,int start,int end,int target){
        if(start>end)return end>=0&&nums[end]==target?end:1;
        int mid=start+(end-start)/2;
        if(target>=nums[mid])return findRightIndex(nums,mid+1,end,target);
        else return findRightIndex(nums,start,mid-1,target);
    }
}
