package com.ccsi.leetcode5;

public class LC543DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.left.left=new TreeNode(6);
        root.left.left.left.left=new TreeNode(7);
        root.left.right.right=new TreeNode(6);
        root.left.right.right.right=new TreeNode(7);
        root.left.right.right.right.right=new TreeNode(8);
        System.out.println(diameterofBinaryTree(root));
    }
    public static int diameterofBinaryTree(TreeNode root){
        if(root==null)return 0;
        int rootDiameter=height(root.left)+height(root.right);
        return Math.max(rootDiameter,Math.max(diameterofBinaryTree(root.left),diameterofBinaryTree(root.right)));
    }
    private static int height(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(height(root.right),height(root.left));
    }
}
