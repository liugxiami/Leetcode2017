package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/16.
 */
public class LC144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildATree();
        List<Integer> list=preorderTraversalDC(root);
        list.forEach(x-> System.out.print(x+ " "));
    }
    //method1 DFS
    public  static List<Integer> result=new ArrayList<>();
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        traversal(root,result);
        return result;
    }
    private static void traversal(TreeNode root,List<Integer> result){
        if(root==null)return;

        result.add(root.val);
        traversal(root.left,result);
        traversal(root.right,result);
    }

    //method2 with stack写法和BFS非常相似
    public static List<Integer> preorderTraversalBFS(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null)return res;

        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.pop();
            res.add(curr.val);

            if(curr.right!=null)stack.push(curr.right); //先right
            if(curr.left!=null)stack.push(curr.left);
        }
        return res;
    }
    //method3 divide and conquer
    public static List<Integer> preorderTraversalDC(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;

        List<Integer> leftList=preorderTraversalDC(root.left); //先找到左子树
        List<Integer> rightList=preorderTraversalDC(root.right);

        result.add(root.val);//preorder，root在最前面
        result.addAll(leftList);
        result.addAll(rightList);

        return result;
    }
}
