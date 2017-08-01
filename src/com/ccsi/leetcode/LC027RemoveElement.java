package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/31.
 */
public class LC027RemoveElement {
    public static void main(String[] args) {
        int[] nums={1,2,2,3,3,3,4};
        System.out.println(removeElement(nums,5));
    }

    public static int removeElement(int[] nums,int val){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int fast=0,slow=0;
        while(fast<len){
            if(nums[fast]!=val){
                nums[slow++]=nums[fast++];
            }else{
                fast++;
            }
        }
        return slow;
    }
}
