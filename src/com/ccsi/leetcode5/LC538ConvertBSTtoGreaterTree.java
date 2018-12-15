package com.ccsi.leetcode5;

public class LC538ConvertBSTtoGreaterTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(2);
        root.right=new TreeNode(13);
        LC538ConvertBSTtoGreaterTree resolution=new LC538ConvertBSTtoGreaterTree();
        TreeNode res=resolution.convertBST(root);
        inOrderDFS(res);
    }
    public TreeNode convertBST(TreeNode root){
        convert(root);
        return root;
    }
    private int sum=0;
    private void convert(TreeNode root){
        if(root==null)return;
        convert(root.right);
        root.val+=sum;
        sum=root.val;
        convert(root.left);
    }
    private static void inOrderDFS(TreeNode root){
        if(root==null)return;
        inOrderDFS(root.left);
        System.out.println(root.val);
        inOrderDFS(root.right);
    }
}
