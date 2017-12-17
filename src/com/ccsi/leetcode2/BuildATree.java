package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/17.
 */
public class BuildATree {
    public static TreeNode buildACompleteTree(){
        //TreeNode root=null;
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        root.left.left.left=new TreeNode(8);
        root.left.left.right=new TreeNode(9);
        return root;
    }
}
