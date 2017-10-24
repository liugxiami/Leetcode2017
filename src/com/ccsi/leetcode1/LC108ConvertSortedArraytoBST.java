package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/10/23.
 */
public class LC108ConvertSortedArraytoBST {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        TreeNode result=sortedArrayToBST(nums);

    }
    public static TreeNode sortedArrayToBST(int[] nums){
        if(nums==null||nums.length==0)return null;
        return helper(nums,0,nums.length-1);
    }

    private static TreeNode helper(int[] nums,int start,int end){
        if(start>end)return null;

        int mid=(end-start)/2+start;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,start,mid-1);
        root.right=helper(nums,mid+1,end);
        return root;
    }
}
