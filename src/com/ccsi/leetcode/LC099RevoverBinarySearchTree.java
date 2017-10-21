package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/20.
 * inorder traversal with stack or DFS
 */
public class LC099RevoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(4);

        root.right=new TreeNode(7);
        root.right.left=new TreeNode(2);
        root.right.right=new TreeNode(10);

        recoverTree1(root);
        DFS(root);
    }
    //method1 inorder traversal with Stack
    public static TreeNode mistake1=null;
    public static TreeNode mistake2=null;
    public static TreeNode pre=null;
    public static void recoverTree(TreeNode root){
        if(root==null)return;

        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr=stack.peek();
            while(curr!=null){
                curr=curr.left;
                stack.push(curr);
            }

            stack.pop();

            if(!stack.isEmpty()){
                curr=stack.pop();

                if(pre!=null&&pre.val>curr.val){
                    if(mistake1==null){
                        mistake1=pre;
                        mistake2=curr;
                    }else{
                        mistake2=curr;
                    }
                }

                pre=curr;
                curr=curr.right;
                stack.push(curr);
            }
        }

        swap(mistake1,mistake2);
    }
    private static void swap(TreeNode node1,TreeNode node2){
        int temp=node1.val;
        node1.val=node2.val;
        node2.val=temp;
    }
    //method2 inorder DFS
    public static void recoverTree1(TreeNode root){
        if(root==null)return;

        helper(root);
        swap(mistake1,mistake2);
    }
    private static void helper(TreeNode root){
        if(root==null)return;

        helper(root.left);

        TreeNode curr=root;
        if(pre!=null&&pre.val>curr.val){
            if(mistake1==null){
                mistake1=pre;
                mistake2=curr;
            }else{
                mistake2=curr;
            }
        }
        pre=curr;

        helper(root.right);
    }

    private static void DFS(TreeNode root){
        if(root==null)return;

        DFS(root.left);
        System.out.println(root.val);
        DFS(root.right);
    }
}
