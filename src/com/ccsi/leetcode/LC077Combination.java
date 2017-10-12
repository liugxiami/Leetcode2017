package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/10.
 */
public class LC077Combination {
    public static void main(String[] args) {
        List<List<Integer>> res=combine(4,2);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    public static List<List<Integer>> combine(int n,int k){
        List<List<Integer>> result=new ArrayList<>();
        if(n<1||k<1||n<k)return result;
        helper(result,new Stack<Integer>(),1,n,k,new boolean[n+1]);
        return result;
    }
    private static void helper(List<List<Integer>> result,Stack<Integer> stack,int index,int n,int k,boolean[] visited){
        if(stack.size()==k){
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index; i <=n; i++) {
            if(!visited[i]){
                stack.push(i);
                visited[i]=true;
                helper(result,stack,i+1,n,k,visited); //这里是i+1，不是index+1
                stack.pop();
                visited[i]=false;
            }
        }
    }
}
