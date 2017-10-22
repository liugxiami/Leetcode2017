package com.ccsi.leetcode1;

import java.util.*;
/**
 * Created by gxliu on 2017/10/21.
 */
public class LC101SymmetricTree {
    public static void main(String[] args) {
        TreeNode root=buildTree();
        System.out.println(isSymmetric2(root));
    }
    //method 1 DFS
    public static boolean isSymmetric(TreeNode root){
        if(root==null)return true;
        TreeNode leftTree=root.left;
        TreeNode rightTree=root.right;

        return helper(leftTree,rightTree);
    }
    private static boolean helper(TreeNode leftTree,TreeNode rightTree){
        if(leftTree==null&&rightTree==null)return true;
        if(leftTree==null||rightTree==null)return false;
        if(leftTree.val!=rightTree.val)return false;
        return helper(leftTree.left,rightTree.right)&&helper(leftTree.right,rightTree.left);
    }
    //method2 BFS with queue
    public static boolean isSymmetric1(TreeNode root){
        if(root==null||root.left==null&&root.right==null)return true;

        Queue<TreeNode> leftQ=new LinkedList<>();
        Queue<TreeNode> rightQ=new LinkedList<>();

        leftQ.offer(root.left);
        rightQ.offer(root.right);

        while(!leftQ.isEmpty()&&!rightQ.isEmpty()){
            TreeNode leftNode=leftQ.poll();
            TreeNode rightNode=rightQ.poll();

            if(leftNode.val!=rightNode.val)return false;

            if(leftNode.left!=null&&rightNode.right==null||leftNode.right!=null&&rightNode.left==null)return false;
            if(leftNode.left==null&&rightNode.right!=null||leftNode.right==null&&rightNode.left!=null)return false;

            if(leftNode.left!=null&&rightNode.right!=null){
                leftQ.offer(leftNode.left);
                rightQ.offer(rightNode.right);
            }
            if(leftNode.right!=null&&rightNode.left!=null){
                leftQ.offer(leftNode.right);
                rightQ.offer(rightNode.left);
            }
        }

        return true;
    }
    //method3 revertTree and compare isSameTree
    public static boolean isSymmetric2(TreeNode root){
        if(root==null||root.left==null&&root.right==null)return true;
        revertTree(root);
        return isSameTree(root.left,root.right);
    }
    private static TreeNode revertTree(TreeNode root){
        if(root==null||root.left==null&&root.right==null)return root;
        TreeNode temp=revertTree(root.left);
        root.left= revertTree(root.right);
        root.right=temp;
        return root;
    }
    private static boolean isSameTree(TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        if(left.val!=right.val)return false;

        return isSameTree(left.left,right.left)&&isSameTree(left.right,right.right);
    }

    private static TreeNode buildTree(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);

        root.right=new TreeNode(2);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(3);
        return root;
    }
}
