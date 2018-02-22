package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/2/8.
 */
public class LC321CreateMaximumNumber {
    public static void main(String[] args) {
       int[] nums1={2,5,6,4,4,0};
       int[] nums2={7,3,8,0,6,5,7,6,2};
       int[] result=maxNumber(nums1,nums2,15);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] maxNumber(int[] nums1,int[] nums2,int k){
        int len1=nums1.length;
        int len2=nums2.length;

        int[] result=new int[k];

        for (int i = Math.max(k-len2,0); i <= Math.min(len1,k); i++) {
            int[] numbers1=getMax(nums1,i);
            int[] numbers2=getMax(nums2,k-i);
            int[] res=merge(numbers1,numbers2);
            result=greater(result,0,res,0)?result:res;
        }
        return result;
    }
    //贪心求一个数组里面的p位最大子数组。
    private static int[] getMax(int[] nums,int p){
        int len=nums.length;
        int[] res=new int[p];
        int index=0;
        for (int i = 0; i < len; i++) {
            while(index>0&&index+len-i>p&&res[index-1]<nums[i])index--; //key
            if(index<p)res[index++]=nums[i];
        }
        return res;
    }
    private static int[] merge(int[] nums1,int[] nums2){
        int len1=nums1.length;
        int len2=nums2.length;
        int[] res=new int[len1+len2];
        int index1=0;
        int index2=0;

        for(int i=0;i<len1+len2;i++){
            if(index1==len1){
                res[i]=nums2[index2++];
                continue;
            }

            if(index2==len2){
                res[i]=nums1[index1++];
                continue;
            }

            if(greater(nums1,index1,nums2,index2))res[i]=nums1[index1++];
            else res[i]=nums2[index2++];
        }
        return res;
    }
    private static boolean greater(int[] nums1,int index1,int[] nums2,int index2){
        if(index1==nums1.length)return false;
        if(index2==nums2.length) return true;

        if(nums1[index1]>nums2[index2])return true;
        else if(nums1[index1]<nums2[index2])return false;
        else return greater(nums1,index1+1,nums2,index2+1);
    }
}
