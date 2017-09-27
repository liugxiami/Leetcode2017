package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/9/24.
 */
public class LC049GroupAnagrams {
    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res=groupAnagrams(strs);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println();
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result=new ArrayList<>();
        if(strs==null||strs.length==0)return result;
        Map<String,ArrayList<String>> map=new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String temp=strs[i];
            //String t=sortStr(temp);
            String t=countChar(temp);
            if(!map.containsKey(t)){
                map.put(t,new ArrayList<>());
            }
            map.get(t).add(temp);
        }

        for(ArrayList<String> list:map.values()){
            result.add(list);
        }
        return result;
    }
    //sort
    private static String sortStr(String str){
        str.toLowerCase();
        char[] arr=str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    //count char
    private static String countChar(String str){
        char[] count=new char[26];
        str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)-'a']++;
        }

        return new String(count);
    }
}
