package com.ccsi.leetcode;

import java.util.Arrays;

/**
 * Created by gxliu on 2017/10/15.
 */
public class LC088MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1={7,9,11,0,0,0,0,0};
        int[] nums2={2,4,6,8,10};
        merge(nums1,3,nums2,5);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
    public static void merge(int[] nums1,int m,int[] nums2,int n){
        if(m==0){
            for (int i = 0; i < n; i++) {
                nums1[i]=nums2[i];
            }
            return;
        }

        if(n==0)return;

        int index=m+n-1;
        int p=m-1,q=n-1;
        while(index>=0&&p>=0&&q>=0){
            if(nums1[p]>=nums2[q])nums1[index--]=nums1[p--];
            else nums1[index--]=nums2[q--];
        }

        while(q>=0)nums1[index--]=nums2[q--];
    }
}
