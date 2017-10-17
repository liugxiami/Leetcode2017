package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/15.
 */
public class LC090SubsetsII {
    public static void main(String[] args) {
        int[] nums={1,2,2};
        List<List<Integer>> res=subsetsWithDup(nums);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        Arrays.sort(nums);
        help(result,new ArrayList<>(),nums,0);
        return result;
    }

    private static void help(List<List<Integer>> result,ArrayList<Integer> list,int[] nums,int start){
        result.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);

            help(result,list,nums,i+1);

            list.remove(list.size()-1);
        }
    }
}
