package com.ccsi.leetcode4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LC473MatchsticksToSquare {
    public static void main(String[] args) {
        int[] nums={1,1,2,2,2};
        System.out.println(makesquare(nums));
    }
    public static boolean makesquare(int[] nums){
        if(nums==null||nums.length<4)return false;
        int parapmeter=0;
        for(int num:nums)parapmeter+=num;
        if(parapmeter%4!=0)return false;
        int edge=parapmeter/4;
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums,new int[4],edge,0);
    }

    private static boolean dfs(int[] nums,int[] sums,int edge,int index){
        if(index==nums.length){
            if(sums[0]==edge&&sums[1]==edge&&sums[2]==edge){
                return true;
            }
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if(sums[i]+nums[index]>edge)continue;
            sums[i]+=nums[index];
            if(dfs(nums,sums,edge,index+1))return true;
            sums[i]-=nums[index];
        }
        return false;
    }
    private static void reverse(int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
