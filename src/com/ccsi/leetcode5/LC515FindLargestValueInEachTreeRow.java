package com.ccsi.leetcode5;

import java.util.*;

public class LC515FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(5);
        root.left.left=new TreeNode(3);
        root.right.right=new TreeNode(9);
        List<Integer> result=largestValues(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    public static List<Integer> largestValues(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> next=new LinkedList<>();
            int max=Integer.MIN_VALUE;
            while(!queue.isEmpty()){
                TreeNode curr=queue.poll();
                max=Math.max(max,curr.val);
                if(curr.left!=null)next.offer(curr.left);
                if(curr.right!=null)next.offer(curr.right);
            }
            result.add(max);
            queue=next;
        }
        return result;
    }
}
