package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/11.
 */
public class LC132PalindromePartitioningII {
    public static void main(String[] args) {
        String s="aab";
        System.out.println(minCut2(s));
    }
    //method1 方法同上一题，用的是DFS+循环，超时。
    private static int min;
    public static int minCut(String s){
        if(s==null||s.length()==0)return 0;
        int len=s.length();
        min=len-1;
        helper(s,0,new ArrayList<String>());
        return min;
    }
    private static void helper(String s,int index,List<String> list){
        if(index==s.length()){
            min=Math.min(min,list.size()-1);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String temp=s.substring(index,i+1);
            if(isPalindrome(temp)){
                list.add(temp);
                helper(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    private static boolean isPalindrome(String s){
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--))return false;
        }
        return true;
    }
    //method2 用DP
    public static int minCut1(String s){
        if(s==null||s.length()==0)return 0;
        int len=s.length();
        int[] cuts=new int[len+1]; //用来存储从i到len的切割数。
        boolean[][] matrix=new boolean[len][len];
        for (int i = 0; i < len; i++) {
            cuts[i]=len-i;
        }

        for (int i = len-1; i >=0 ; i--) {
            for (int j = i; j < len; j++) {
                if((i==j||j==i+1||matrix[i+1][j-1])&&s.charAt(i)==s.charAt(j)){
                    matrix[i][j]=true;
                    cuts[i]=Math.min(cuts[i],cuts[j+1]+1);
                }
            }
        }
        return cuts[0]-1;
    }
    //method3 一种很巧的方法
    public static int minCut2(String s){
        if(s==null||s.length()==0)return 0;
        int len=s.length();
        int[] cuts=new int[len+1];
        for (int i = 0; i <= len; i++) {
            cuts[i]=i-1;
        }

        for (int i = 0; i <len ; i++) {
            for (int j = 0; i-j >=0&&i+j<len&&s.charAt(i-j)==s.charAt(i+j) ; j++) {
                cuts[i+j+1]=Math.min(cuts[i+j+1],cuts[i-j]+1);//奇数对称的回文
            }
            for(int j=1;i-j+1>=0&&i+j<len&&s.charAt(i-j+1)==s.charAt(i+j);j++){
                cuts[i+j+1]=Math.min(cuts[i+j+1],cuts[i-j+1]+1);//偶数对称的回文
            }
        }
        return cuts[len];
    }
}
