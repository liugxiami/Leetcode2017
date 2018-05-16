package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/5/15.
 */
public class LC404SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(sumOfLeftLeaves(root));
    }
    public static int sumOfLeftLeaves(TreeNode root){
       if(root==null)return 0;
       return helper(root.left,true)+helper(root.right,false);
    }
    private static int helper(TreeNode curr,boolean isLeft){
        if(curr==null)return 0;//空子树的话就返回0

        if(curr.left==null&&curr.right==null){ //判断是否是叶子节点，是的化
            if(isLeft)return curr.val; //再看是否是左叶子
            else return 0; //右叶子的话就返回0
        }
        return helper(curr.left,true)+helper(curr.right,false); //否则就递归
    }
}
