package com.ccsi.leetcode;

import java.util.*;
/**
 * Created by gxliu on 2017/10/10.
 */
public class LC078Subsets {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> res=subsets1(nums);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    //method1 bt
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        helper(result,new ArrayList<>(),nums,0);
        return result;
    }
    private static void helper(List<List<Integer>> result,ArrayList<Integer> list,int[] nums,int index){
        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }

    //method2
    public static List<List<Integer>> subsets1(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        int len=nums.length;
        int target=1;
        while(len-->0)target*=2;

        for (int i = 0; i < target; i++) {
            List<Integer> list=new ArrayList<>();
            int temp=i;
            int index=0;
            while(temp>0){
                if((temp&1)==1)list.add(nums[index]);
                temp>>=1;
                index++;
            }
            result.add(list);
        }
        return result;
    }
}
