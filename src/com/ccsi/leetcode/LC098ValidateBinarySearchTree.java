package com.ccsi.leetcode;


import java.util.*;

/**
 * Created by gxliu on 2017/10/19.
 */
public class LC098ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(3);
        root.left.left=new TreeNode(10);
        root.left.right=new TreeNode(4);

        root.right=new TreeNode(7);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(10);
        System.out.println(isValidBST1(root));
    }
    //divide and conquer,出错，过不了。
    public static boolean isValidBST(TreeNode root){
        if(root==null)return true;
        return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private static boolean isValidBST(TreeNode curr,long left,long right){
        if(curr==null)return true;

        if(curr.val<=left||curr.val>=right)return false;

        return isValidBST(curr.left,left,curr.val)&&isValidBST(curr.right,curr.val,right);
    }

    //inorder traveral
    public  static boolean isValidBST1(TreeNode root){
        if(root==null)return true;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode tempHead=stack.peek();
            while(tempHead!=null){
                tempHead=tempHead.left;
                stack.push(tempHead);
            }

            stack.pop();

            if(!stack.isEmpty()){
                tempHead=stack.pop();
                if(pre!=null&&pre.val>=tempHead.val)return false;
                pre=tempHead;
                tempHead=tempHead.right;
                stack.push(tempHead);
            }
        }
        return true;
    }
}
