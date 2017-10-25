package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/24.
 */
public class LC111MinmumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildATree();
        System.out.println(minDepth1(root));
    }
    //BFS
    public static int minDepth(TreeNode root){
        if(root==null)return 0;
        int level=1;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> next=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode temp=queue.poll();
                if(temp.left==null)return level;
                else next.offer(temp.left);

                if(temp.right==null)return level;
                else next.offer(temp.right);
            }
            queue=next;
            level++;
        }
        return level;
    }
    //DFS
    public static int minDepth1(TreeNode root){
        if(root==null)return 0;
        return getMin(root);
    }
    private static int getMin(TreeNode root){
        if(root==null)return Integer.MAX_VALUE;
        if(root.left==null&&root.right==null)return 1;
        return 1+Math.min(getMin(root.left),getMin(root.right));
    }
}
