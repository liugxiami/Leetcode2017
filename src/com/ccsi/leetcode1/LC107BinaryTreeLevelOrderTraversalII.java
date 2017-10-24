package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/23.
 */
public class LC107BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildATree();
        List<List<Integer>> res=levelOrderBottom(root);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)return result;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Queue<TreeNode> next=new LinkedList<>();
            List<Integer> list=new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode temp=queue.poll();
                list.add(temp.val);

                if(temp.left!=null)next.offer(temp.left);
                if(temp.right!=null)next.offer(temp.right);
            }

            result.add(0,list);
            queue=next;
        }
        return result;
    }
}
