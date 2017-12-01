package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/30.
 */
public class LC173BinarySearchTreeIterator {
    //其实这就是BST的inOrder的loop实现（用stack）。
    private Stack<TreeNode> stack;
    public LC173BinarySearchTreeIterator(TreeNode root){
        stack=new Stack<>();
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    public int next(){
        TreeNode curr=stack.pop();
        int result=curr.val;

        if(curr.right!=null){
            curr=curr.right;
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root=BuildTree.buildBST();
        LC173BinarySearchTreeIterator BSTIterator=new LC173BinarySearchTreeIterator(root);
        while(BSTIterator.hasNext()){
            System.out.println(BSTIterator.next());
        }
    }
}
