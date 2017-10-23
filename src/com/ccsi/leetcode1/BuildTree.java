package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/10/22.
 */
public class BuildTree {
    public static TreeNode buildATree(){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        root.right.right.right=new TreeNode(10);
        return root;
    }
}
