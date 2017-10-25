package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/10/24.
 */
public class LC110BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildATree();
        System.out.println(isBalanced1(root));
    }
    //method 1
    public static boolean isBalanced(TreeNode root){
        if(root==null)return true;
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        if(Math.abs(leftHeight-rightHeight)>1)return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    private static int getHeight(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
    //method 2
    public static boolean isBalanced1(TreeNode root){
        if(root==null)return true;
        return maxDepth(root)!=-1;
    }

    private static int maxDepth(TreeNode root){
        if(root==null)return 0;
        int leftHeight= maxDepth(root.left);
        if(leftHeight==-1)return -1;
        int rightHeight= maxDepth(root.right);
        if(rightHeight==-1)return -1;

        if(Math.abs(leftHeight-rightHeight)>1)return -1;
        return 1+Math.max(leftHeight,rightHeight);
    }
}
