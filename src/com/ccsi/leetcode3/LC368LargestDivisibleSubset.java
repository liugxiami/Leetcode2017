package com.ccsi.leetcode3;

import java.util.*;
/**
 * Created by gxliu on 2018/4/2.
 */
public class LC368LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums={1,2,6,9,12};
        List<Integer> result=largestDivisibleSubset1(nums);
        result.forEach(x-> System.out.println(x));
    }
    //method1 O[N^3]复杂度高了
    public static List<Integer> largestDivisibleSubset(int[] nums){
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        List<List<Integer>> subsets=new ArrayList<>();
        helper(subsets,nums,0);
        for(List<Integer> list:subsets){
            if(list.size()>result.size()){
                result.clear();
                result=list;
            }
        }
        return result;
    }
    private static void helper(List<List<Integer>> subsets,int[] nums,int index){
        if(index==nums.length)return;

        int curr=nums[index];
        List<List<Integer>> next=new ArrayList<>(subsets);

        if(index==0){
            List<Integer> temp=new ArrayList<>();
            temp.add(curr);
            next.add(temp);
        }else {
            for(List<Integer> list:subsets){
                List<Integer> temp=new ArrayList<>();
                temp.add(curr);
                for(Integer num:list){
                    if(curr%num==0||num%curr==0)temp.add(num);
                }
                next.add(temp);
                if(temp.size()!=list.size()+1){
                    next.add(new ArrayList<Integer>(list));
                }
            }
        }
        subsets.clear();
        subsets.addAll(next);
        helper(subsets,nums,index+1);
    }
    //method2 DP 类似于求最长增高子序列
    public static List<Integer> largestDivisibleSubset1(int[] nums){
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        int len=nums.length;
        Arrays.sort(nums); //先将数组排序，省去互相取余，肯定是大的数对小的数取余。

        int[] dp=new int[len]; //存储长度
        int[] index=new int[len]; //为了回溯，存储上一个可以被当前这个数整除的数的index

        Arrays.fill(dp,1);
        Arrays.fill(index,-1);

        int max_dp=0;  //保存最大的长度
        int max_index=0; //以及相应的index，回溯的时候就从这里开始。
        for (int i = 0; i < len; i++) {
            for (int j = i-1; j >=0; j--) {
                if(nums[i]%nums[j]==0&&dp[j]+1>dp[i]){ //如果这个数对前面的某个数取余为0，并且
                    //其最大长度小于前一个的长度+1，那么更新当前这个数的最大长度，以及index。
                    dp[i]=dp[j]+1;
                    index[i]=j;
                }

                if(max_dp<dp[i]){ //不断更新max
                    max_dp=dp[i];
                    max_index=i;
                }
            }
        }
        //找回数
        for(int i=max_index;i!=-1;i=index[i]){
            result.add(nums[i]);
        }
        return result;
    }
}
