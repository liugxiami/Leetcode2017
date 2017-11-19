package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/16.
 */
public class LC145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildATree();
        List<Integer> res=postorderTraversal(root);
        res.forEach(x-> System.out.print(x+" "));
    }
    public static List<Integer> postorderTraversalDFS(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;
        traversal(root,result);
        return result;
    }
    private static void traversal(TreeNode root,List<Integer> result){
        if(root==null)return;

        traversal(root.left,result);
        traversal(root.right,result);
        result.add(root.val);
    }
    //method2 with stack,和前一题preorder几乎一样，只是插入list的顺序不一样。
    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;

        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.pop();
            result.add(0,curr.val);
            if(curr.left!=null)stack.push(curr.left);
            if(curr.right!=null)stack.push(curr.right);
        }
        return result;
    }
    //method3 divide&conquer
    public static List<Integer> postorderTraversalDC(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;

        List<Integer> leftList=postorderTraversalDC(root.left);
        List<Integer> rightList=postorderTraversalDC(root.right);

        result.addAll(leftList);
        result.addAll(rightList);
        result.add(root.val);
        return result;
    }
}
