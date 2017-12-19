package com.ccsi.leetcode2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gxliu on 2017/12/18.
 */
public class LC226InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root=BuildATree.buildACompleteTree();
        traveralByLayer(root);
        TreeNode res=invertTreeBFS(root);
        traveralByLayer(res);
    }
    //DFS
    public static TreeNode invertTree(TreeNode root){
        if(root==null)return root;

        TreeNode temp=root.left; //pre-order
        root.left=root.right;
        root.right=temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    //BFS
    public static TreeNode invertTreeBFS(TreeNode root){
        if(root==null)return root;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(curr.left!=null)queue.offer(curr.left);
            if(curr.right!=null)queue.offer(curr.right);

            TreeNode temp=curr.left;  //在经典的BFS上加上对换，注意对换的位置是在循环里面，入队列之后在额外做点事。
            curr.left=curr.right;
            curr.right=temp;
        }
        return root;
    }
    private static void traveralByLayer(TreeNode root){
        if(root==null)return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> next=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode temp=queue.poll();
                System.out.print(temp.val+" ");
                if(temp.left!=null)next.offer(temp.left);
                if(temp.right!=null)next.offer(temp.right);
            }
            System.out.println();
            queue=next;
        }
    }
}
