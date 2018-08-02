package com.ccsi.leetcode4;

public class LC450DeleteNodeInABST {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(6);
        root.right=new TreeNode(12);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(8);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(9);
        root.right.right=new TreeNode(14);
        TreeNode res=deleteNode(root,8);
        System.out.println("=========");
    }
    /*
    step:
    Recursively find the node that has the same value as the key, while setting the left/right nodes equal
    to the returned subtree
    Once the node is found, have to handle the below 4 cases
        1.node doesn't have left or right - return null
        2.node only has left subtree- return the left subtree
        3.node only has right subtree- return the right subtree
        4.node has both left and right - find the minimum value in the right subtree, set that value to the
        currently found node, then recursively delete the minimum value in the right subtree
     */
    public static TreeNode deleteNode(TreeNode root,int key){
        if(root==null)return null;
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }else{
            if(root.left==null)return root.right;
            else if(root.right==null)return root.left;

            TreeNode min=findMin(root.right);
            root.val=min.val;
            root.right=deleteNode(root.right,root.val);
        }
        return root;
    }
    private static TreeNode findMin(TreeNode root){
        while(root.left!=null)root=root.left;
        return root;
    }

}
