package com.ccsi.leetcode4;


/**
 * Created by gxliu on 2018/7/30.
 */
public class LC449SerializeAndDeserializeBSTDFS {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9};
        TreeNode root=makeABST(nums,0,nums.length-1);
        String res=serialize(root);
        System.out.println(res);
        TreeNode result=deserialize(res);
        DFS1(result);
    }
    private static void DFS1(TreeNode root){
        if(root==null)return;
        DFS1(root.left);
        System.out.println(root.val);
        DFS1(root.right);
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

    //DFS
    public static String serialize(TreeNode root){
        if(root==null)return "";
        StringBuilder res=new StringBuilder();
        DFS(root,res);
        return res.toString();
    }
    private static void DFS(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("n"+".");//n表示null节点。
            return;
        }
        sb.append(root.val+".");
        DFS(root.left,sb);
        DFS(root.right,sb);
    }
    private static int indexFrom=0;
    public static TreeNode deserialize(String data){
        int indexTo=data.indexOf(".",indexFrom);
        if(data==null||data.length()==0||indexFrom>=data.length()-1||data.charAt(indexFrom)=='n'){
            indexFrom+=2;
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(data.substring(indexFrom,indexTo)));
        indexFrom=indexTo+1;
        root.left=deserialize(data);
        root.right=deserialize(data);
        return root;
    }
}
