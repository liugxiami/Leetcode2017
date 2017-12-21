package com.ccsi.leetcode2;

import java.util.Stack;

/**
 * Created by gxliu on 2017/12/20.
 */
public class LC230KthSmallestElementInABST {
    public static void main(String[] args) {
        TreeNode root=BuildATree.buildABST();
        System.out.println(kthSmallest1(root,3));
    }
    //method1 inorder-DFS with a counter
    private static int result;
    private static int count =0;

    public static int kthSmallest(TreeNode root,int k){
        inOrder(root,k);
        return result;
    }
    private static void inOrder(TreeNode curr, int k){
        if(curr==null||count>=k)return;
        inOrder(curr.left,k);
        System.out.println(curr.val);
        count++;
        if(count ==k){
            result=curr.val;
        }
        inOrder(curr.right,k);
    }
    //method2 iterative with Stack
    public static int kthSmallest1(TreeNode root,int k){
        if(root==null)return -1;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr=stack.peek();
            while(curr!=null){
                curr=curr.left;
                stack.push(curr);
            }
            stack.pop();//pop掉null。

            if(!stack.isEmpty()){
                curr=stack.pop();
                System.out.println(curr.val);
                k--;
                if(k==0)return curr.val;

                stack.push(curr.right); //这边不管是否是null都进栈，如果是null，上面42行的还是会pop掉它。
            }
        }
        return -1;
    }
}
