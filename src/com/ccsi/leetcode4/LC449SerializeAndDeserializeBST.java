package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/7/29.
 */
public class LC449SerializeAndDeserializeBST {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        TreeNode root=makeABST(nums,0,nums.length-1);
        String res=Serialize(root);
        System.out.println(res);
        TreeNode result=deserialize(res);
        DFS(result);
    }
    private static void DFS(TreeNode root){
        if(root==null)return;
        DFS(root.left);
        System.out.println(root.val);
        DFS(root.right);
    }
    private static TreeNode makeABST(int[] nums,int start,int end){
        if(start>end)return null;
        if(start==end)return new TreeNode(nums[start]);

        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=makeABST(nums,start,mid-1);
        root.right=makeABST(nums,mid+1,end);
        return root;
    }
    //BFS
    public static String Serialize(TreeNode root){
        String res="";
        if(root==null)return res;
        StringBuilder result=new StringBuilder();
        BFS(root,result);
        result.deleteCharAt(result.length()-1);
        res=result.toString();
        return  res;
    }
    private static void BFS(TreeNode root,StringBuilder str){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        str.append(root.val);
        str.append('-');
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp.left!=null){
                queue.offer(temp.left);
                str.append(temp.left.val);
                str.append('-');
            }else str.append(".-");
            if(temp.right!=null){
                queue.offer(temp.right);
                str.append(temp.right.val);
                str.append('-');
            }else str.append(".-");
        }
    }

    public static TreeNode deserialize(String data){
        String[] strings=data.split("-");
        return deserializeBFS(strings);
    }
    private static TreeNode deserializeBFS(String[] strs){
        if(strs==null||strs.length==0)return null;
        TreeNode root=new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int index=1;
        while(!queue.isEmpty()){
            TreeNode curr=queue.poll();
            if(strs[index].equals("."))curr.left=null;
            else {
                curr.left=new TreeNode(Integer.valueOf(strs[index]));
                queue.offer(curr.left);
            }
            index++;

            if(strs[index].equals("."))curr.right=null;
            else {
                curr.right=new TreeNode(Integer.valueOf(strs[index]));
                queue.offer(curr.right);
            }
            index++;
        }
        return root;
    }
}
