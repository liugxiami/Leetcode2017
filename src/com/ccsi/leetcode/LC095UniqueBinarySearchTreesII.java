package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/18.
 */
public class LC095UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        List<TreeNode> res=generateTrees(5);
        for (int i = 0; i < res.size(); i++) {
            TreeNode curr=res.get(i);
            DFS(curr);
            System.out.println();
        }
    }
    //n-queens方法，循环里套递归。
    public static List<TreeNode> generateTrees(int n){
        List<TreeNode> result=new ArrayList<>();
        if(n<1)return result;

        result=generateTrees(n,1,n);
        return result;
    }
    //辅助递归函数，需要两个参数，为开头和结尾索引
    private static List<TreeNode> generateTrees(int n,int start,int end){
        List<TreeNode> result=new ArrayList<>();
        if(start>end){
            result.add(null);
            return result;
        }
        //一个循环迭代，将数组分两部分，小于该数和大于该数的
        for (int index = start; index <= end; index++) {
            //递归这两部分，因为BST的性质决定了其左子树的都小于跟节点，右子树的都大于跟节点
            List<TreeNode> leftTrees= generateTrees(n,start,index-1);
            List<TreeNode> rightTrees=generateTrees(n,index+1,end);
            //对左边的任何组合与右变的任何组合进行结合，也就是说需要两个循环
            for (int i = 0; i < leftTrees.size(); i++) {
                for (int j = 0; j < rightTrees.size(); j++) {
                    //index为根节点
                    TreeNode root=new TreeNode(index);
                    //任何一个左list中的子树
                    root.left=leftTrees.get(i);
                    //与任何一个右list中的子树进行组合成一颗完整的树
                    root.right=rightTrees.get(j);
                    //将树加进结果集中
                    result.add(root);
                }
            }
        }
        return result;
    }

    private static void DFS(TreeNode root){
        if(root==null)return;
        DFS(root.left);
        System.out.print(root.val+" ");
        DFS(root.right);
    }

}
