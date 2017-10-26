package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/10/25.
 */
public class LC114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode root=BuildTree.buildBST();
        flatten2(root);
    }
    //method1 用一个stack来缓存碰到的右子树。
    public static void flatten(TreeNode root){
        if(root==null||root.left==null&&root.right==null)return;
        Stack<TreeNode> stack=new Stack<>();  //用一个stack来辅助
        TreeNode curr=root;

        while(curr!=null){
            if(curr.right!=null)stack.push(curr.right); //如果右子树不为空就进栈
            if(curr.left!=null){
                curr.right=curr.left;                  //如果左子树不为空，就将其变成右子树，注：右子树已经进栈了
                curr.left=null;                        //并将左子树设为空
            }else if(!stack.isEmpty()){                //如果左子树是空的，并且stack里面有元素，就将stack里
                // 的最后面进去的那个吐出来，接到当前根节点的右子树上去。
                curr.right=stack.pop();
            }

            curr=curr.right;                           //当前节点往右子树上走一位，一直走到空为止。
        }
    }

    //method 2 将右子树接到左子树的最右下角的节点右子树上去。
    public static void flatten1(TreeNode root){
        if(root==null||root.left==null&&root.right==null)return;
        TreeNode curr=root;

        while(curr!=null){
            TreeNode right=curr.right;

            if(curr.left!=null){
                TreeNode left=curr.left;
                while(left.right!=null){
                    left=left.right;
                }
                left.right=right;

                curr.right=curr.left;
                curr.left=null;
            }

            curr=curr.right;
        }
    }
    //method3 pre-order stack
    public  static void flatten2(TreeNode root){
        if(root==null||root.left==null&&root.right==null)return;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();

            if(temp.right!=null)stack.push(temp.right);
            if(temp.left!=null)stack.push(temp.left); //到此为止，都是preorder的标准代码

            //connect
            temp.left=null;       //新建链表，左子树为空
            if(stack.isEmpty()){  //右子树的建立，如果stack为空，那么是到了叶子节点了
                temp.right=null;
            }else{
                temp.right=stack.peek(); //否则右子树指向stack里面的元素，注意不能pop破坏结构。
            }
        }
    }
}
