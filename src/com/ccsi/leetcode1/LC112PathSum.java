package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/24.
 */
public class LC112PathSum {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildTreeForPathSum();
        System.out.println(hasPathSum(root,22));
    }
    //DFS
    public static boolean hasPathSum(TreeNode root,int sum){
        if(root==null)return false; //到头了还没返回true那么返回false。
        sum-=root.val; //先将sum减去当前节点的val
        if(sum==0&&root.left==null&&root.right==null)return true; //如果到了叶子节点，sum被减成0了，返回true
        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);//否则，递归分别看左右子树。
    }
}
