package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/3/13.
 */
public class LC337HouseRobIII {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(4);
        root.right=new TreeNode(5);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.right=new TreeNode(1);

        TreeNode curr=new TreeNode(3);
        curr.left=new TreeNode(2);
        curr.right=new TreeNode(3);
        curr.left.right=new TreeNode(3);
        curr.right.right=new TreeNode(1);
        System.out.println(robBT(root));
    }
    //按层打印的方法，太天真了，题目说明不能连着偷，但要注意，可以隔两个偷，所以按层打印的方法不行，还是得BT.
    public static int rob(TreeNode root){
        if(root==null)return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        int oddSum=0;
        int evenSum=0;
        boolean isOdd=true;

        while(!queue.isEmpty()){
            Queue<TreeNode> temp=new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode curr=queue.poll();
                if(isOdd)oddSum+=curr.val;
                else evenSum+=curr.val;

                if(curr.left!=null)temp.offer(curr.left);
                if(curr.right!=null)temp.offer(curr.right);
            }
            isOdd=!isOdd;
            queue=temp;
        }
        return oddSum>evenSum?oddSum:evenSum;
    }
    //BT
    public static int robBT(TreeNode root){
        if(root==null)return 0;
        int[] result=helper(root);
        return result[0]>result[1]?result[0]:result[1];
    }

    private static int[] helper(TreeNode root){
        if(root==null){
            int[] res={0,0};
            return res;
        }

        int[] res=new int[2];
        int[] left=helper(root.left);
        int[] right=helper(root.right);
        //res[0]为偷了当前节点，res[1]为未偷当前
        // res[0] is when root is selected, res[1] is when not.
        res[0]=root.val+left[1]+right[1];
        res[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return res;
    }
}
