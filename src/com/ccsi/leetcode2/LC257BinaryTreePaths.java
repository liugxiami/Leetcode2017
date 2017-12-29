package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/28.
 */
public class LC257BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(5);

        List<String> result=binaryTreePaths(root);

        result.forEach(x-> System.out.println(x));
    }
    public static List<String> binaryTreePaths(TreeNode root){
        List<String> result=new ArrayList<>();
        if(root==null)return result;

        helper(result,new ArrayList<>(),root);
        return result;
    }
    private static void helper(List<String> result, List<Integer> path, TreeNode curr){
        path.add(curr.val); //保证了传进来的node不会为空，可以方向的进行BT

        if(curr.left==null&&curr.right==null){ //如果到了叶子节点，那么就做点事。
            StringBuilder sb=new StringBuilder();
            for(Integer num:path){
                sb.append(num).append('-').append('>');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);

            result.add(sb.toString());
        }else{          //否则的话就进行递归看该节点左右子树
            if(curr.left!=null) helper(result,path,curr.left);
            if(curr.right!=null) helper(result,path,curr.right);
        }

        path.remove(path.size()-1); //进行backTracking
    }
}
