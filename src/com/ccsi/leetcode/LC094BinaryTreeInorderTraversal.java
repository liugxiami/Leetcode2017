package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/17.
 */
public class LC094BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        List<Integer> res=inorderTraversal(root);
        res.forEach(x-> System.out.println(x));
    }
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;
        inorderBFS(root,result);
        return result;
    }
    //method1 DFS
    private static void inorderDFS(TreeNode curr,List<Integer> result){
        if(curr==null)return;
        inorderDFS(curr.left,result);
        result.add(curr.val);
        inorderDFS(curr.right,result);
    }
    //method BFS
    private static void inorderBFS(TreeNode head,List<Integer> result){
        Stack<TreeNode> stack=new Stack<>();
        stack.push(head);
        //两个while循环。
        while(!stack.isEmpty()){
            TreeNode tempHead=stack.peek(); //新声明一个TreeNode
            while(tempHead!=null){    //一直往左走到低，一直压栈，还会把最左边的null压进去。
                stack.push(tempHead.left);
                tempHead=tempHead.left;
            }
            stack.pop(); //去掉最后压进来的null
            //走完之后，看看stack是否为空，不空的话就吐一个吐出来
            if(!stack.isEmpty()){
                tempHead=stack.pop();//将最后一个非空的node给吐出来给tempHead。
                result.add(tempHead.val);//pop出来之后处理一下。
                stack.push(tempHead.right); //将这个tempHead的右子节点入栈。
            }
        }
    }
    //method BFS
    private static void preorderBFS(TreeNode head,List<Integer> result){
        Stack<TreeNode> stack=new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            result.add(temp.val);//这个位置不重要了，反正都是先打印
            if(temp.right!=null)stack.push(temp.right); //先压右边，在下面，后出来。

            if(temp.left!=null)stack.push(temp.left);//后压左边，在上面，先出来。
        }
    }
}
