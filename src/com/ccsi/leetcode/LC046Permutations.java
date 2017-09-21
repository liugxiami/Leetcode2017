package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/9/20.
 */
public class LC046Permutations {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> result=permute1(arr);
        for (int i = 0; i < result.size(); i++) {
            result.get(i).forEach(x-> System.out.print(x));
            System.out.println();
        }
    }
    //BT 用一个set来记录是否已经访问过。
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        helper(nums,result,new Stack<Integer>(),new HashSet<Integer>());
        return result;
    }

    private static void helper(int[] nums,List<List<Integer>> result,Stack<Integer> path,HashSet<Integer> visited){
        if(path.size()>nums.length)return;

        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!visited.contains(nums[i])){
                path.push(nums[i]);
                visited.add(nums[i]);
                helper(nums,result,path,visited);
                path.pop();
                visited.remove(nums[i]);
            }
        }
    }
    //用一个boolean的数组来记录是否被访问过
    public static List<List<Integer>> permute1(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null||nums.length==0)return result;
        Arrays.sort(nums);
        helper(nums,result,new Stack<Integer>(),new boolean[nums.length+1]);
        return result;
    }

    private static void helper(int[] nums,List<List<Integer>> result,Stack<Integer> path,boolean[] visited){
        if(path.size()>nums.length)return;

        if(path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i]){
                continue;
            }
            path.push(nums[i]);
            visited[i]=true;
            helper(nums,result,path,visited);
            path.pop();
            visited[i]=false;
        }
    }

}
