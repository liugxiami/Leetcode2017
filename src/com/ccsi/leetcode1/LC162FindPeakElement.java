package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/26.
 */
public class LC162FindPeakElement {
    public static void main(String[] args) {
        int[] nums={4,2};
        System.out.println(findPeakElement(nums));
    }
    //method1 recursion，二分法,因为index为-1或len都是-infinite，传统的二分法法找到中点mid，比较这个mid与mid-1或mid
    //+1两个元素，如果是小于mid-1，我们就往前半段找，因为至少mid-1这个是大于mid，这就可能是个顶点；如果是大于mid-1这个
    //数，就先看mid+1与mid的大小，如果也是大于mid+1的，那么mid本身就是顶点，直接返回，如果是小于的，就到后半段找，原理
    //同上。
    public static int findPeakElement(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        return find(nums,0,len-1);
    }
    private static int find(int[] nums,int start,int end){
        if(start==end)return start;
        if(start+1==end)return nums[start]>nums[end]?start:end;

        int mid=start+(end-start)/2;

        if(nums[mid]>nums[mid-1]){
            if(nums[mid]>nums[mid+1])return mid;
            else return find(nums,mid+1,end);
        }else{
            return find(nums,start,mid-1);
        }
    }
    //method2 loop
    public static int findPeakElement1(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int start=0;
        int end=len-1;
        while(start+1<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<nums[mid-1])end=mid-1;
            else{
                if(nums[mid]>nums[mid+1])return mid;
                else start=mid+1;
            }
        }
        return nums[start]>nums[end]?start:end;
    }
}
