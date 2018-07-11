package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/7/10.
 */
public class LC442FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> res=findDuplicates2(nums);
        res.forEach(x-> System.out.println(x));
    }
    //method1 with extra space
    public static List<Integer> findDuplicates(int[] nums){
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length<=1)return result;
        int len=nums.length;
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < len; i++) {
            if(set.contains(nums[i]))result.add(nums[i]);
            else set.add(nums[i]);
        }
        return result;
    }
    //method2 O(nlogn)
    public static List<Integer> findDuplicates1(int[] nums){
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length<=1)return result;
        int len=nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < len; i++) {
            if(nums[i]==nums[i-1])result.add(nums[i]);
        }
        return result;
    }
    //method3
    public static List<Integer> findDuplicates2(int[] nums){
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length<=1)return result;
        int len=nums.length;
        //nums[i]中存i+1，两个循环，第一个循环类似于排序
        for (int i = 0; i < len; ) {
            int curr=nums[i];
            if(nums[curr-1]!=curr){
                int temp=nums[curr-1];
                nums[curr-1]=curr;
                nums[i]=temp;
            }else{
                i++;
            }
        }
        //第二个循环找不正确的数值，即nums[i]存的不是i+1，把这个nums[i]放到结果集
        for (int i = 0; i < len; i++) {
            if(nums[i]!=i+1)result.add(nums[i]);
        }
        return result;
    }
}
