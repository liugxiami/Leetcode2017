package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/10/22.
 */
public class LC105ContructBinaryTreeFromPreorderandInorderTraversal {
    public static void main(String[] args) {
        int[] preorder={1,2,4,5,3,6,7};
        int[] inorder={4,2,5,1,6,3,7};
        TreeNode root=buildTree(preorder,inorder);
        DFS(root);
    }
    public static TreeNode buildTree(int[] preorder,int[] inorder){
        if(preorder==null||inorder==null)return null;
        if(preorder.length!=inorder.length)return null;
        if(preorder.length==0&&inorder.length==0)return null;

        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private static TreeNode helper(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart>preEnd)return null;
        TreeNode root=new TreeNode(preorder[preStart]);

        int index=-1;
        for (int i = inStart; i <=inEnd; i++) {
            if(inorder[i]==preorder[preStart]){
                index=i;
                break;
            }
        }
        root.left=helper(preorder,preStart+1,index-inStart+preStart,inorder,inStart,index-1);
        root.right=helper(preorder,index-inStart+preStart+1,preEnd,inorder,index+1,inEnd);
        return root;
    }
    private static void DFS(TreeNode root){
        if(root==null)return;

        //System.out.println(root.val);
        DFS(root.left);
        System.out.println(root.val);
        DFS(root.right);
    }
}
