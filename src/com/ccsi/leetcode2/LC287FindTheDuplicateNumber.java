package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/5.
 */
public class LC287FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums={4,6,5,1,3,2,5,7};
        System.out.println(findDuplicate(nums));
    }
    //method linked list cycle II 的变形
    public static int findDuplicate(int[] nums){
        if(nums==null||nums.length<2)return -1;
        int slow=nums[0];
        int fast=nums[nums[0]];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        fast=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
