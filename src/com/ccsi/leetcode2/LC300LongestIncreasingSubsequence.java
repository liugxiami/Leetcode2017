package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2018/1/10.
 */
public class LC300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS1(nums));
    }
    private static int max=0;
    public static int lengthOfLIS(int[] nums){
        if(nums==null||nums.length==0)return 0;
        List<Integer> list=new ArrayList<>();
        helperBT(list,nums,0);
        return max;
    }
    private static void helperBT(List<Integer> list,int[] nums,int index){
        if(index==nums.length){
            max=Math.max(max,list.size());
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if(list.isEmpty()){
                list.add(nums[i]);
                helperBT(list,nums,i+1);
                list.remove(list.size()-1);
            }
            else if(nums[i]>list.get(list.size()-1)){
                list.add(nums[i]);
                helperBT(list,nums,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    //DP f(i)=max(f(i),f(j)+1),其中1到n-1为外层循环，j为子数组0到i。
    public static int lengthOfLIS1(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int[] cache=new int[len];
        Arrays.fill(cache,1);

        int max=1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    cache[i]=Math.max(cache[i],cache[j]+1);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            max=Math.max(max,cache[i]);
        }
        return max;
    }
}
