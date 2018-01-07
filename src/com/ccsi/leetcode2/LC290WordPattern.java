package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2018/1/7.
 */
public class LC290WordPattern {
    public static void main(String[] args) {
        String pattern="abba";
        String str="dog cat cat dog";
        System.out.println(wordPattern(pattern,str));
    }
    public static boolean wordPattern(String pattern,String str){
        if(pattern==null&&str==null)return true;
        if(pattern==null||str==null)return false;
        int pLen=pattern.length();

        str=str.trim();
        String[] strings=str.split(" ");
        int wLen=strings.length;
        if(pLen!=wLen)return false;

        Set<String> set=new HashSet<>();
        Map<Character,String> map=new HashMap<>();

        for (int i = 0; i < pLen; i++) {
            char c=pattern.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,strings[i]);
                if(set.contains(strings[i]))return false;
                else set.add(strings[i]);
            }else{
                if(!strings[i].equals(map.get(c)))return false;
            }
        }

        return true;
    }
}
