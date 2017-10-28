package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/27.
 */
public class LC116PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        TreeLinkNode root=buildTreeLinkNodeTree();
        connect1(root);
        traversal(root);
    }
    //method 1: BFS + 双queue
    public static void connect(TreeLinkNode root){
        if(root==null||root.left==null&&root.right==null)return;
        Queue<TreeLinkNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeLinkNode> next=new LinkedList<>();
            TreeLinkNode pre=null;
            while(!queue.isEmpty()){
                TreeLinkNode curr=queue.poll();
                if(pre!=null){
                    pre.next=curr;
                }
                pre=curr;
                if(curr.left!=null)next.offer(curr.left);
                if(curr.right!=null)next.offer(curr.right);
            }
            queue=next;
        }
    }

    //method 2 recursive
    public static void connect1(TreeLinkNode root){
        if(root==null||root.left==null&&root.right==null)return;
        //pre-order DFS,对root进行处理
        if(root.right!=null){
            root.left.next=root.right; //如果这个root的右子树节点不为空，那么让左子树的next指向当前节点。
            if(root.next!=null){       //还要查看root.next是否为空，有的话就让root.right.next指向root.next.left.画图就明白了。
                root.right.next=root.next.left;
            }
        }

        connect1(root.left);
        connect1(root.right);
    }

    public static void traversal(TreeLinkNode root){
        if(root==null)return;
        while(root!=null){
            TreeLinkNode curr=root;
            while(curr!=null){
                System.out.println(curr.val);
                curr=curr.next;
            }
            root=root.left;
        }
    }

    public static TreeLinkNode buildTreeLinkNodeTree(){
        TreeLinkNode root=new TreeLinkNode(1);
        root.left=new TreeLinkNode(2);
        root.right=new TreeLinkNode(3);
        root.left.left=new TreeLinkNode(4);
        root.left.right=new TreeLinkNode(5);
        //root.right.left=new TreeLinkNode(6);
        root.right.right=new TreeLinkNode(7);
        root.left.left.left=new TreeLinkNode(8);
        root.left.left.right=new TreeLinkNode(9);
        root.right.right.left=new TreeLinkNode(10);
        root.right.right.right=new TreeLinkNode(11);
        return root;
    }
}
