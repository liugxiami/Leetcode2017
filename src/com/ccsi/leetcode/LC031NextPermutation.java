package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/8/3.
 */
public class LC031NextPermutation {
    public static void main(String[] args) {
        int[] nums={1,3,2};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void nextPermutation(int[] nums){
        if(nums==null||nums.length<=1)return;
        int len=nums.length;

        //find the last increase index
        int index=-1;
        for (int i = len-2; i >=0 ; i--) {
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }

        if(index==-1){
            reverseList(nums,0,len-1);
            return;
        }

        //find the bigger index
        int bigIndex=index+1;
        for (int i = len-1; i >index ; i--) {
            if(nums[i]>nums[index]){
                bigIndex=i;
                break;
            }
        }

        swap(nums,index,bigIndex);
        reverseList(nums,index+1,len-1);
    }
    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private static void reverseList(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
