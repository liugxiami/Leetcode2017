package com.ccsi.leetcode5;

import java.util.*;

public class LC508MostFrequenetSubtreeSum {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(2);
        root.right=new TreeNode(-5);
        int[] result=findFrequentTreeSum1(root);
        for (int r = 0; r < result.length; r++) {
            System.out.println(result[r]);
        }
    }
    //method 1
    public static int[] findFrequentTreeSum(TreeNode root){
        if(root==null)return new int[0];
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>(); //key--sum, value--frequency
        helper(root,map);
        int max=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(max<entry.getValue()){
                max=entry.getValue();
                list.clear();
                list.add(entry.getKey());
            }else if(max==entry.getValue()){
                list.add(entry.getKey());
            }
        }
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
    //DFS
    private static int helper(TreeNode root,Map<Integer,Integer> map){
        if(root.left==null&&root.right==null){
            map.put(root.val,map.getOrDefault(root.val,0)+1);
            return root.val;
        }
        int sum=root.val;
        if(root.left!=null)sum+=helper(root.left,map);
        if(root.right!=null)sum+=helper(root.right,map);
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
    //method 2 其实和上面是一样的，可以更为简洁一点
    private static Map<Integer,Integer> map;
    private static int maxFre;
    public static int[] findFrequentTreeSum1(TreeNode root){
        if(root==null)return new int[0];
        map=new HashMap<>();
        maxFre=0;
        postOrder(root);
        List<Integer> list=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==maxFre){
                list.add(key);
            }
        }
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
    private static int postOrder(TreeNode root){
        if(root==null)return 0;
        int left=postOrder(root.left);
        int right=postOrder(root.right);
        int sum=left+right+root.val;
        int count=map.getOrDefault(sum,0)+1;
        map.put(sum,count);
        maxFre=Math.max(maxFre,count);
        return sum;
    }
}
