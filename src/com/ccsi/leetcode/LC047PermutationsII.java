package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/9/20.
 */
public class LC047PermutationsII {
    public static void main(String[] args) {
        int[] arr={1,1,2};
        List<List<Integer>> res=permutaUnique(arr);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x));
            System.out.println();
        }
    }
    public static List<List<Integer>> permutaUnique(int[] nums){
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
            if(visited[i]||(i!=0&&nums[i]==nums[i-1]&&visited[i-1])) continue; //与上一题不同的地方，1.访问过了不在访问
            //2.如果当前这个数和前面是一样的，并且前面那个数被访问过了，那么这个也不在访问。
//            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
//            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
//            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
//            不应该让后面的2使用。
            path.push(nums[i]);
            visited[i]=true;
            helper(nums,result,path,visited);
            path.pop();
            visited[i]=false;
        }
    }
}
