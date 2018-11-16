package com.ccsi.leetcode5;

import java.util.*;

public class LC513FindBottomLeftTreeValue {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);
        root.right.left.left=new TreeNode(7);
        root.right.left.right=new TreeNode(8);
        System.out.println(findBottomLeftValue1(root));
    }
    //method1 classic rows scan
    public static int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int leftmost=root.val;
        while(!queue.isEmpty()){
            Queue<TreeNode> next=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode curr=queue.poll();
                if(curr.left!=null)next.offer(curr.left);
                if(curr.right!=null)next.offer(curr.right);
            }
            queue=next;
            if(!queue.isEmpty())leftmost=queue.peek().val;
        }
        return leftmost;
    }
    //method2 leetcode discussion
    public static int findBottomLeftValue1(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root=queue.poll();
            if(root.left!=null)queue.offer(root.left);
            if(root.right!=null)queue.offer(root.right);
        }
        return root.val;
    }

}
