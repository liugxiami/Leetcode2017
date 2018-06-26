package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/6/25.
 */
public class LC437PathSumIII {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(-3);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        root.left.left.left=new TreeNode(3);
        root.left.left.right=new TreeNode(-2);
        root.left.right.right=new TreeNode(1);
        root.right.right=new TreeNode(11);
        System.out.println(pathSum(root,8));
    }
    public static int pathSum(TreeNode root,int sum){
        if(root==null)return 0;
        //recursion 返回从root开始的和等于sum的次数，+从左子树开始的和等于sum的次数+从右子树开始的和等于sum的次数。
        return helper(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    private static int helper(TreeNode curr,int remain){
        int result=0; //从当前节点开始，其初始次数为0
        if(curr==null)return result; //如果当前节点为空，那么就直接返回次数
        if(remain-curr.val==0)result++; //如果到当前节点为止，其remain为0了，说明从起始到现在的和为sum，result++；
        result+=helper(curr.left,remain-curr.val); //递归计算左子树和右子树
        result+=helper(curr.right,remain-curr.val);
        return result;
    }
}
