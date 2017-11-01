package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/10/31.
 */
public class LC124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildTreeForPathSum();
        int result=maxPathSum1(root);
        System.out.println(result);
    }

    //method1，该方法不行。
    public static int maxPathSum(TreeNode root){
        if(root==null)return 0;

        int leftSum=Math.max(0,maxSinglePath(root.left));  //保存左子树的最大路径。
        int rightSum=Math.max(0,maxSinglePath(root.right));

        int sum=leftSum+rightSum+root.val; //将题目要求的最大路径计算出来，
        //就是左子树的最大路径+右子树的最大路径+根的val。

        //当然题目要求的最大路径也可能在左子树上或右子树上。递归计算。
        sum=Math.max(sum,Math.max(maxPathSum(root.left),maxPathSum(root.right)));

        return sum;
    }

    private static int  maxSinglePath(TreeNode curr){
        if(curr==null)return 0;

        return curr.val+Math.max(maxSinglePath(curr.left),maxSinglePath(curr.right));
    }

    //method 2
    public static int maxSum=Integer.MIN_VALUE;//题目要求的最大路径和。
    public static int maxPathSum1(TreeNode root) {
        max(root);
        return maxSum;
    }

    private static int max(TreeNode curr){
        if(curr==null)return 0; //如果是棵空树，返回0；

        int leftSum=Math.max(0,max(curr.left)); //递归求左子树的和，如果小于0则返回0，去掉这棵子树
        int rightSum=Math.max(0,max(curr.right));//同理

        maxSum=Math.max(maxSum,curr.val+leftSum+rightSum); //当前树的最大路径和是curr.val加上左右子树路径和的总和，更新最大路径

        return curr.val+Math.max(leftSum,rightSum); //对于求树的singlepath的总和，是当前节点加上左或右子树较大的那棵树。如果没有上面这行code，就是
        //典型的求树的最大路径的code。
    }
}
