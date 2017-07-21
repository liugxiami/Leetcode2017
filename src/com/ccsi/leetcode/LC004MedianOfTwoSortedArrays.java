package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/13.
 */
public class LC004MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1={1,2,5};
        int[] nums2={3,4,6};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        int len=nums1.length+nums2.length;
        if(len%2==1){
            return findKth(len/2+1,nums1,0,nums2,0);
        }else{
            return (findKth(len/2+1,nums1,0,nums2,0)+findKth(len/2,nums1,0,nums2,0))/2.0;
        }
    }
    private static int findKth(int k,int[] numsA,int aStart,int[] numsB,int bStart){
        if(aStart>=numsA.length)return numsB[bStart+k-1];
        if(bStart>=numsB.length)return numsA[aStart+k-1];
        if(k==1)return Math.min(numsA[aStart],numsB[bStart]);

        int mA=aStart+k/2-1;
        int mB=bStart+k/2-1;

        int midA=mA<numsA.length?numsA[mA]:Integer.MAX_VALUE;
        int midB=mB<numsB.length?numsB[mB]:Integer.MAX_VALUE;

        if(midA>midB){
            return findKth(k-k/2,numsA,aStart,numsB,mB+1);
        }else{
            return findKth(k-k/2,numsA,mA+1,numsB,bStart);
        }
    }
}
