package com.ccsi.leetcode1;

import com.sun.org.apache.regexp.internal.RE;

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
    public static TreeNode buildBST(){
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);
        return root;
    }
    public static TreeNode buildTreeForPathSum(){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.left.left=new TreeNode(11);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);

        root.right=new TreeNode(8);
        root.right.left=new TreeNode(13);
        root.right.right=new TreeNode(4);
        root.right.right.left=new TreeNode(5);
        root.right.right.right=new TreeNode(1);
        return root;

    }
}
