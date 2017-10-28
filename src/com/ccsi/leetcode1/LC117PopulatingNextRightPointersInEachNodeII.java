package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/28.
 */
public class LC117PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {
        TreeLinkNode root=LC116PopulatingNextRightPointersinEachNode.buildTreeLinkNodeTree();
        connectDFS(root);
        LC116PopulatingNextRightPointersinEachNode.traversal(root);
    }
    //method 1 BFS 和前面一题一模一样
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
    //method 2 DFS
    public static void connectDFS(TreeLinkNode root){
        if(root==null||(root.left==null&&root.right==null))return;

        TreeLinkNode temp=null; //用来记录当前节点下一层的后面一个节点，目的是为了让其next能接到root.next
        //的下一层的节点
        if(root.left!=null&&root.right!=null){
            root.left.next=root.right;
            temp=root.right;
        }else{
            temp=root.left==null?root.right:root.left;
        }

        TreeLinkNode next=root.next;
        while(next!=null){  //因为root的next的子树可能是空的，但其next.next的子树又存在，所以需要一个while
            //循环来将temp与next连起来。
            if(next.left!=null){
                temp.next=next.left;
                break;
            }else if(next.right!=null){
                temp.next=next.right;
                break;
            }else{
                next=next.next;
            }
        }

        connectDFS(root.left);
        connectDFS(root.right);
    }
}
