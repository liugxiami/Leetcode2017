package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/22.
 */
public class LC102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root=buildATree();
        List<List<Integer>> result=levelOrder(root);
        for (int i = 0; i < result.size(); i++) {
            result.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    //双queue，对于结果需要的list，每次都在入queue的时候同时进list，这样就不用在用一个循环来将queue里的内容在入list
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)return result;

        Queue<TreeNode> outerQ=new LinkedList<>();
        outerQ.offer(root);

        while(!outerQ.isEmpty()){
            Queue<TreeNode> innerQ=new LinkedList<>();
            List<Integer> list=new ArrayList<>();

            while(!outerQ.isEmpty()){
                TreeNode temp=outerQ.poll();
                list.add(temp.val);
                if(temp.left!=null)innerQ.add(temp.left);
                if(temp.right!=null)innerQ.add(temp.right);
            }

            outerQ=innerQ;
            result.add(list);
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
