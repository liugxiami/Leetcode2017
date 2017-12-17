package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/17.
 */
public class LC222CountCompleteTreeNodes {
    public static void main(String[] args) {
        TreeNode root=BuildATree.buildACompleteTree();
        System.out.println(countNodes(root));
    }
    public static int countNodes(TreeNode root){
        if(root==null)return 0;

        int leftHeight=getLeftHeight(root);
        int rightHeight=getRightHeight(root);

        if(leftHeight==rightHeight){
            return (1<<leftHeight)-1;
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
    public static int getLeftHeight(TreeNode curr){
        int height=0;
        while(curr!=null){
            curr=curr.left;
            height++;
        }
        return height;

    }
    public static int getRightHeight(TreeNode curr){
        int height=0;
        while(curr!=null){
            curr=curr.right;
            height++;
        }
        return height;

    }
}
