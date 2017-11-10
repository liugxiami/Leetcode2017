package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/9.
 */
public class LC131PalindromePartitioning {
    public static void main(String[] args) {
        String s="aab";
        List<List<String>> res=partition(s);
        for(List<String> list:res){
            list.forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    public static List<List<String>> partition(String s){
        List<List<String>> result=new ArrayList<>();
        if(s==null||s.length()==0)return result;
        helper(result,new ArrayList<>(),s,0);
        return result;
    }
    //递归加循环，Subsets,Permutations,Combination Sum,Palindrome partitioning解法类似。
    private static void helper(List<List<String>> result,List<String> list,String s,int index){
        if(index==s.length()){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String str=s.substring(index,i+1);
            if(isPalindrome(str)){   //
                list.add(str);
                helper(result,list,s,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    private static boolean isPalindrome(String str){
        int left=0,right=str.length()-1;
        while(left<right){
            if(str.charAt(left++)!=str.charAt(right--))return false;
        }
        return true;
    }
}
