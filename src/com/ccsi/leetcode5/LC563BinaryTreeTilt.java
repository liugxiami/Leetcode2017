package com.ccsi.leetcode5;

public class LC563BinaryTreeTilt {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        System.out.println(findTilt(root));
    }
    public static int tilt=0; //用一个字段来存储tilt，这有妙用
    public static int findTilt(TreeNode root){
        helper(root); //需要一个辅助函数
        return tilt;
    }
    private static int helper(TreeNode root){
        if(root==null)return 0;
        int ltilt=helper(root.left);
        int rtilt=helper(root.right);
        tilt+=Math.abs(ltilt-rtilt); //tilt累加了各子树的tilt，这也是题目不太清楚的地方
        return ltilt+rtilt+root.val; //辅助函数的返回值时该节点为根节点的总和
    }
}
