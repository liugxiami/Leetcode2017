package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/8/2.
 */
public class LC030SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s="goodnoongoodnoonnoongood";
        String[] words={"good","noon"};
        List<Integer> res=findSubstring(s,words);
        res.forEach(x-> System.out.print(x+" "));
    }
    //题目需要理解透彻，题意是words里面所有的单词以某种组合在一次成为s里面的某个substring，返回完成无误的组合substring
    // 的起始位置。
    // 用两个hashmap来做，一个用来保存words，key为word，value是个数。另一个用来保存正在查看的substring是否包含所有的
    // 前一个map里的单词
    public static List<Integer> findSubstring(String s,String[] words){
        List<Integer> result=new ArrayList<>();
        if(s==null||s.length()==0)return result;
        if(words==null||words.length==0)return result;

        int sLen=s.length();
        int wLen=words[0].length();
        int wSize=words.length;

        if(sLen<wLen*wSize)return result;
        Map<String, Integer> toFind=new HashMap<>();
        Map<String,Integer> found=new HashMap<>();

        for (int i = 0; i < wSize; i++) {
            if(!toFind.containsKey(words[i])){
                toFind.put(words[i],1);
            }else{
                toFind.put(words[i],toFind.get(words[i])+1);
            }
        }

        for (int i = 0; i <= sLen - wLen * wSize; i++) {
            found.clear();
            int j;
            for (j = 0; j < wSize; j++) {
                int k=i+j*wLen;
                String temp=s.substring(k,k+wLen);
                if(!toFind.containsKey(temp))break;
                if(!found.containsKey(temp)){
                    found.put(temp,1);
                }else{
                    found.put(temp,found.get(temp)+1);
                }
                if(toFind.get(temp)<found.get(temp))break;
            }
            if(j==wSize)result.add(i);
        }

        return result;
    }
}
