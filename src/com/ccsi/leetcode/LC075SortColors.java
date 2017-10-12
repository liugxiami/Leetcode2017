package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/10/8.
 */
public class LC075SortColors {
    public static void main(String[] args) {
        int[] nums={2,1,2,1,1,2,2,0,0,0,1,0};
        sortColors1(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    //桶排序，取巧的方法
    public static void sortColors(int[] nums){
        if(nums==null||nums.length==0)return;
        int len=nums.length;

        int[] bucket=new int[3];
        for (int i = 0; i < len; i++) {
            bucket[nums[i]]++;
        }

        int index=0;
        for (int i = 0; i < bucket.length; i++) {
            int n=bucket[i];
            while(n-->0)nums[index++]=i;
        }
    }
    //quick sort
    public static void sortColors1(int[] nums){
        if(nums==null||nums.length==0)return;
        int len=nums.length;
        sort(nums,0,len-1);
    }
    private static void sort(int[] nums,int start,int end){
        if(start>=end)return;
        int pivot=nums[start];
        int index=start+1;
        for (int i = start+1; i <= end; i++) {
            if(nums[i]<pivot)swap(nums,index++,i);
        }

        int mid=index-1;
        swap(nums,start,mid);
        sort(nums,start,mid-1);
        sort(nums,mid+1,end);
    }
    private static void swap(int[] nums,int p,int q){
        if(p==q)return;
        int temp=nums[p];
        nums[p]=nums[q];
        nums[q]=temp;
    }

}
