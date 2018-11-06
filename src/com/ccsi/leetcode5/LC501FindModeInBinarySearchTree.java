package com.ccsi.leetcode5;

import java.util.*;

public class LC501FindModeInBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.right=new TreeNode(2);
        root.right.right.right=new TreeNode(2);
        int[] result=findMode(root);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] findMode(TreeNode root){
        if(root==null)return new int[0];
        Map<Integer,Integer> map=new HashMap<>(); //key--node value, value--frequency
        DFS(root,map);
        int max=0;
        for(Integer value:map.values()){
            max=Math.max(max,value);
        }
        List<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==max)list.add(entry.getKey());
        }
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
    private static void DFS(TreeNode root,Map<Integer,Integer> map){
        if(root==null)return;

        map.put(root.val,map.getOrDefault(root.val,0)+1);

        DFS(root.left,map);
        DFS(root.right,map);
    }

}
