package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/22.
 */
public class LC104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildATree();
        System.out.println(maxDepth1(root));
    }
    //DFS
    public static int maxDepth(TreeNode root){
        if(root==null)return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    //BFS
    public static int maxDepth1(TreeNode root){
        int level=0;
        if(root==null) return level;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Queue<TreeNode> next=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode temp=queue.poll();
                if(temp.left!=null)next.offer(temp.left);
                if(temp.right!=null)next.offer(temp.right);
            }
            queue=next;
            level++;
        }
        return level;
    }
}
