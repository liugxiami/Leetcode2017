package com.ccsi.leetcode5;

public class LC530MinimumAbsoluteDifferenceInBST {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(2);
        System.out.println(getMinimumDifference1(root));
    }
    public static int minDif =Integer.MAX_VALUE;
    //method 1, recursion, compared the adjacent note value and current root to it's left
    // subtree's rightest node, and current root to it's right subtree's leftest note value.
    public static int getMinimumDifference(TreeNode root){
        if(root==null)return minDif;
        if(root.left!=null){
            TreeNode left=root.left;
            while(left.right!=null){
                left=left.right;
            }
            minDif =Math.min(minDif,Math.abs(root.val-left.val));
            minDif =Math.min(minDif,getMinimumDifference(root.left));
        }
        if(root.right!=null){
            TreeNode right=root.right;
            while(right.left!=null){
                right=right.left;
            }
            minDif =Math.min(minDif,Math.abs(root.val-right.val));
            minDif =Math.min(minDif,getMinimumDifference(root.right));
        }
        return minDif;
    }
    //method 2, this is BST, if we do inorder, the numbers will be sorted. compare the adjacent nums
    //will be OK
    public static Integer pre=null;
    public static int getMinimumDifference1(TreeNode root){
        if(root==null)return minDif;
        getMinimumDifference1(root.left);

        if(pre!=null){
            minDif=Math.min(minDif,Math.abs(pre-root.val));
        }
        pre=root.val;

        getMinimumDifference1(root.right);
        return minDif;
    }
}
