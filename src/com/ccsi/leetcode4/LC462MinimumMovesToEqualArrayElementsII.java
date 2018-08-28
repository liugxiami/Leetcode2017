package com.ccsi.leetcode4;

import java.util.*;

public class LC462MinimumMovesToEqualArrayElementsII {
    public static void main(String[] args) {
        int[] nums={5,9,11,13};
        System.out.println(minMoves2(nums));
    }
    public static int minMoves2(int[] nums){
        int minMove=0;
        if(nums.length<=1)return minMove;
        Arrays.sort(nums);
        int len=nums.length;
        if(len%2==1){
            int mid=len/2;
            for(int num:nums){
                minMove+=(Math.abs(num-nums[mid]));
            }
        }else{
            int lmid=len/2-1;
            int rmid=len/2;
            int lsum=0,rsum=0;
            for(int num:nums){
                lsum+=(Math.abs(num-nums[lmid]));
                rsum+=(Math.abs(num-nums[rmid]));
            }
            minMove=Math.min(lsum,rsum);
        }
        return minMove;
    }
}
