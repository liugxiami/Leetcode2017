package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/25.
 */
public class LC113PathSumII {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildTreeForPathSum();
        List<List<Integer>> res=pathSum(root,22);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    public static List<List<Integer>> pathSum(TreeNode root,int sum){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)return result;
        helper1(result,new ArrayList<>(),root,sum);
        return result;
    }

    private static void helper(List<List<Integer>> result,List<Integer> list,TreeNode curr,int remains){
        if(curr==null)return; //递归结束条件

        remains-=curr.val;
        list.add(curr.val);

        if(curr.left==null&&curr.right==null&&remains==0){
            result.add(new ArrayList<>(list));//满足到叶子节点并且路径和等于sum，添加到结果集中去
        }                                     //此处必须是new ArrayList<>(list)

        helper(result,list,curr.left,remains);
        helper(result,list,curr.right,remains);

        list.remove(list.size()-1); //回溯
    }
    private static void helper1(List<List<Integer>> result,List<Integer> list,TreeNode curr,int remains){
        remains-=curr.val;
        list.add(curr.val);

        if(curr.left==null&&curr.right==null&&remains==0){
            result.add(new ArrayList<>(list));//满足到叶子节点并且路径和等于sum，添加到结果集中去
        }

        if(curr.left!=null)helper(result,list,curr.left,remains);
        if(curr.right!=null)helper(result,list,curr.right,remains);

        list.remove(list.size()-1); //回溯
    }
}
