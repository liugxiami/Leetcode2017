package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/22.
 */
public class LC235LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(6);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(3);
        root.left.right.right=new TreeNode(5);
        root.right=new TreeNode(8);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(9);

        TreeNode res=lowestCommonAncestor1(root,new TreeNode(2),new TreeNode(3));
        System.out.println(res.val);
    }
    //method1 recursive
    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)return root;
        if(p==null)return q;
        if(q==null)return p;

        if(root.val<p.val&&root.val<q.val)return lowestCommonAncestor(root.right,p,q);
        else if(root.val>p.val&&root.val>q.val)return lowestCommonAncestor(root.left,p,q);
        else return root;
    }
    //method2 iterative
    public static TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)return root;
        if(p==null)return q;
        if(q==null)return p;

        TreeNode curr=root;
        while(curr!=null){
            if(curr.val<p.val&&curr.val<q.val)curr=curr.right;
            else if(curr.val>p.val&&curr.val>q.val)curr=curr.left;
            else break;
        }
        return curr;
    }
}
