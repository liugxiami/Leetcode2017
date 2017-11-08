package com.ccsi.leetcode1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by gxliu on 2017/11/6.
 */
public class LC129SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildBST();
        System.out.println(sumNumbers1(root));
    }
    //method1,BT
    private static int sum=0;
    public static int sumNumbers(TreeNode root){
        if(root==null)return 0;
        StringBuilder path=new StringBuilder();
        sumDFS(path,root);

        return sum;
    }
    private static void sumDFS(StringBuilder path,TreeNode curr){
        if(curr==null)return;
        path.append(curr.val);
        if(curr.left==null&&curr.right==null){
            String temp=path.toString();
            sum+=Integer.parseInt(temp);
        }
        sumDFS(path,curr.left);
        sumDFS(path,curr.right);
        path.deleteCharAt(path.length()-1);
    }
    //method2 DFS,更通用的解法,典型的DFS
    public static int sumNumbers1(TreeNode root){
        if(root==null)return 0;
        return helper(root,0);
    }
    private static int helper(TreeNode curr,int pre){
        if(curr==null)return 0;

        int sum=pre*10+curr.val;
        if(curr.left==null&&curr.right==null)return sum;
        return helper(curr.left,sum)+helper(curr.right,sum);
    }
}
