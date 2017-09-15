package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/9/14.
 */
public class LC040CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates,int target){
        List<List<Integer>> result=new ArrayList<>();
        if(candidates==null||candidates.length==0||target<=0)return result;
        Stack<Integer> path=new Stack<>();
        Arrays.sort(candidates);  //需要排序，方便后面看是否有重复的元素
        sum2(candidates,path,result,0,target);
        return result;
    }

    private static void sum2(int[] candidates,Stack<Integer> path,List<List<Integer>> result,int index,int target){
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }else if(target<0)return;

        for (int i = index; i < candidates.length; i++) {
            if(i!=index&&candidates[i]==candidates[i-1])continue;  //如果有重复的，跳过，保证结果没有重复结果。
            path.push(candidates[i]);
            sum2(candidates,path,result,i+1,target-candidates[i]); //与上题不同的是这里i+1（就是说
            //递归下个循环时是用下一个元素了，不再是当前的这个元素。 ）
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] cans={10,1,2,7,6,1,5};
        List<List<Integer>> res=combinationSum2(cans,8);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
}
