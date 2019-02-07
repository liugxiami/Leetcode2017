package com.ccsi.leetcode5;

public class LC572SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode s=new TreeNode(3);
        s.left=new TreeNode(4);
        s.right=new TreeNode(5);
        s.left.left=new TreeNode(1);
        s.left.right=new TreeNode(2);
        s.left.right.left=new TreeNode(0);

        TreeNode t=new TreeNode(4);
        t.left=new TreeNode(1);
        t.right=new TreeNode(2);

        System.out.println(isSubtree(s,t));
    }
    public static boolean isSubtree(TreeNode s,TreeNode t){
        if(s==null)return false;
        if(t==null)return true;

        return isSameTree(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    private static boolean isSameTree(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null)return true;
        if(t1==null||t2==null)return false;
        if(t1.val!=t2.val)return false;
        else return isSameTree(t1.left,t2.left)&&isSameTree(t1.right,t2.right);
    }
}
