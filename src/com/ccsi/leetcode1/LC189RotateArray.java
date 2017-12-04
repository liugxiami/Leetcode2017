package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/12/3.
 */
public class LC189RotateArray {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        rotate(nums,0);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void rotate(int[] nums,int k){
        if(nums==null||nums.length<2||k==0)return;
        int len=nums.length;
        k%=len;
        if(k<0)k+=len;

        reverse(nums,0,len-1);

        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }
    private static void reverse(int[] nums,int start,int end){
        if(start==end)return;
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
