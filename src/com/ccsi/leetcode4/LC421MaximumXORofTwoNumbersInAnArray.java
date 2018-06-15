package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/6/14.
 */
public class LC421MaximumXORofTwoNumbersInAnArray {
    public static void main(String[] args) {
        int[] nums={3,10,5,25,2,8};
        System.out.println(findMaximumXOR(nums));
    }
    public static int findMaximumXOR(int[] nums){
        int max=0;
        if(nums==null||nums.length==0)return max;
        TrieNode root=new TrieNode();
        for(int num:nums){
            TrieNode curr=root;
            for (int i = 31; i >=0; i--) {
                int bit=(num>>i)&1;
                if(bit==1){
                    if(curr.one==null)curr.one=new TrieNode();
                    curr=curr.one;
                }else{
                    if(curr.zero==null)curr.zero=new TrieNode();
                    curr=curr.zero;
                }
            }
        }

        for(int num:nums){
            TrieNode curr=root;
            int res=0;
            for (int i = 31; i >=0; i--) {
                int bit=(num>>i)&1;
                if(bit==1){
                    if(curr.zero!=null){
                        curr=curr.zero;
                        res|=(1<<i);
                    }else{
                        curr=curr.one;
                        //res|=(0<<i);
                    }
                }else{
                    if(curr.one!=null){
                        curr=curr.one;
                        res|=(1<<i);
                    }else{
                        curr=curr.zero;
                        //res|=(0<<i);
                    }
                }
            }
            max=max>res?max:res;
        }
        return max;
    }
    private static class TrieNode{
        TrieNode one;
        TrieNode zero;
    }
}
