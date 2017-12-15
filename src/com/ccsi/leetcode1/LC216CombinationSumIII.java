package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/13.
 */
public class LC216CombinationSumIII {
    public static void main(String[] args) {
        List<List<Integer>> res=combinationSum3(3,9);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> curr=res.get(i);
            curr.forEach(x-> System.out.print(x));
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum3(int k,int n){
        List<List<Integer>> result=new ArrayList<>();
        if(k<1||n<1)return result;
        backtrack(result,new ArrayList<>(),k,n,1);
        return result;
    }
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int k, int remain, int start){
        if(tempList.size()>k||remain<0)return;
        else if(tempList.size()==k&&remain==0){
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < 10; i++) {
            tempList.add(i);
            remain-=i;

            backtrack(list,tempList,k,remain,i+1);

            tempList.remove(tempList.size()-1);
            remain+=i;
        }
    }
}
