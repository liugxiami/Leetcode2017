package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2018/1/30.
 */
public class LC315CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int[] nums={5,2,6,1};
        List<Integer> result=countSmaller(nums);
        result.forEach(x-> System.out.println(x));
    }
    public static class Node{
        int num;
        Node left;
        Node right;
        int smaller=1;

        public Node(int number){
            this.num=number;
        }
    }
    public static List<Integer> countSmaller(int[] nums){
        List<Integer> res=new ArrayList<>();
        if(nums==null||nums.length==0)return res;
        int len=nums.length;
        Node root=new Node(nums[len-1]);
        res.add(0);

        for (int i = len-2; i >=0; i--) {
            res.add(0,insert(nums[i],root));
        }
        return res;
    }
    private static int insert(int num,Node root){
        int count=0;
        while(true){
            if(num<root.num){
                root.smaller++;
                if(root.left==null){
                    root.left=new Node(num);
                    break;
                }else root=root.left;
            }else{
                count+=root.smaller;
                if(root.right==null){
                    root.right=new Node(num);
                    break;
                }else root=root.right;
            }
        }
        return count;
    }
}
