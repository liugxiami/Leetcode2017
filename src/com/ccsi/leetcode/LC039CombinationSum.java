package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/9/13.
 */
public class LC039CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> result=new ArrayList<>();
        if(candidates==null||candidates.length==0||target<0)return result;
        Stack<Integer> path=new Stack<>();
        sum2(candidates,path,result,0,target);
        return result;
    }
    private static void sum(int[] candidates,Stack<Integer> path,List<List<Integer>> result,int index,int target){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }else if(target<0){
            return;
        }

        for (int i = index; i <candidates.length; i++) {
            path.push(candidates[i]);
            target-=candidates[i];
            sum(candidates,path,result,i,target);
            path.pop();
            target+=candidates[i];
        }
    }
    //method2
    private static void sum2(int[] candidates,Stack<Integer> path,List<List<Integer>> result,int index,int target){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }else if(target<0)return;

        for (int i = index; i < candidates.length; i++) {
            path.push(candidates[i]);
            sum2(candidates,path,result,i,target-candidates[i]);
            path.pop();
        }

    }

    public static void main(String[] args) {
        int[] cans={2,3,6,7};
        List<List<Integer>> res=combinationSum(cans,7);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
}
