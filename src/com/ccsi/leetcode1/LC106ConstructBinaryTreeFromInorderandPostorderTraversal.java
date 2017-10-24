package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/10/22.
 */
public class LC106ConstructBinaryTreeFromInorderandPostorderTraversal {
    public static void main(String[] args) {

        int[] inorder={4,2,5,1,6,3,7};
        int[] postorder={4,5,2,6,7,3,1};
        TreeNode root=buildTree(inorder,postorder);
        DFS(root);
    }
    public static TreeNode buildTree(int[] inorder,int[] postorder){
        if(inorder==null||postorder==null)return null;
        if(inorder.length!=postorder.length)return null;
        if(inorder.length==0&&postorder.length==0)return null;

        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    private static TreeNode helper(int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        if(inStart>inEnd)return null;
        TreeNode root=new TreeNode(postorder[postEnd]);

        int index=0;
        for (int i = inStart; i <= inEnd; i++) {
            if(inorder[i]==postorder[postEnd]){
                index=i;
                break;
            }
        }

        root.left=helper(inorder,inStart,index-1,postorder,postStart,index-1-inStart+postStart);
        root.right=helper(inorder,index+1,inEnd,postorder,index-inStart+postStart,postEnd-1);
        return root;
    }
    private static void DFS(TreeNode root){
        if(root==null)return;

        DFS(root.left);
        //System.out.println(root.val);
        DFS(root.right);
        System.out.println(root.val);
    }
}
