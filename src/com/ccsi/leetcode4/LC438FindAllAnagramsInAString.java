package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/6/26.
 */
public class LC438FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s="abab";
        String p="ab";
        List<Integer> res=findAnagrams1(s,p);
        res.forEach(a-> System.out.println(a));
    }
    //Method1 map
    public static List<Integer> findAnagrams(String s,String p){
        List<Integer> result=new ArrayList<>();
        if(s==null||s.length()==0||p==null||p.length()==0||s.length()<p.length())return result;
        Set<String> set=new HashSet<>();
        helper(set,new StringBuilder(),p,new HashSet<>());
        for (int i = 0; i <= s.length()-p.length(); i++) {
            String str=s.substring(i,i+p.length());
            if(set.contains(str))result.add(i);
        }
        return result;
    }
    private static void helper(Set<String> res,StringBuilder sb, String p,Set<Integer> visited){
        if(sb.length()==p.length()){
            res.add(sb.toString());
        }else{
            for (int i = 0; i < p.length(); i++) {
                if(!visited.contains(i)){
                    sb.append(p.charAt(i));
                    visited.add(i);

                    helper(res,sb,p,visited);

                    sb.deleteCharAt(sb.length()-1);
                    visited.remove(i);
                }
            }
        }
    }
    //method1 sliding window
    public static List<Integer> findAnagrams1(String s,String p){
        List<Integer> result=new ArrayList<>();
        if(s==null||s.length()==0||p==null||p.length()==0||s.length()<p.length())return result;
        int[] map=new int[256];
        char[] chars=s.toCharArray();
        for(char c:p.toCharArray())map[c]++;

        int left=0,right=0;
        int count=p.length();
        while(right<s.length()){
            if(map[chars[right++]]-->=1)count--;
            if(count==0)result.add(left);
            if(right-left==p.length()&&map[chars[left++]]++>=0)count++;
        }
        return result;
    }
}
