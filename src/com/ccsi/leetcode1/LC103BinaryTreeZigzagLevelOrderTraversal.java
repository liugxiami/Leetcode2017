package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/22.
 */
public class LC103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root=buildATree();
        List<List<Integer>> res=zigzagLevelOrder(root);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)return result;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        int level=0;
        while(!queue.isEmpty()){
            Queue<TreeNode> next=new LinkedList<>();
            List<Integer> list=new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode temp=queue.poll();
                if(level%2==0){
                    list.add(temp.val);
                }else{
                    list.add(0,temp.val);
                }

                if(temp.left!=null)next.offer(temp.left);
                if(temp.right!=null)next.offer(temp.right);
            }

            result.add(list);
            queue=next;
            level++;
        }
        return result;
    }
    private static TreeNode buildATree(){
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        return root;
    }
}
