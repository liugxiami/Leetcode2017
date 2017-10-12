package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/9.
 * 双指针，和hashMap。
 */
public class LC076MinimumWindowSubstring {
    public static void main(String[] args) {
        String s="a";
        String t="a";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s,String t){
        String res="";
        if(s==null||t==null||s.length()==0||t.length()==0)return res;

        Map<Character,Integer> map=new HashMap<>();
        int count=0,start=0,len=Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            char c=t.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
            count++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)>=0)count--;
            }

            while(count==0){
                char temp=s.charAt(start);
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                    if(map.get(temp)>0){
                        if(i-start+1<len){
                            len=i-start+1;
                            res=s.substring(start,i+1);
                        }
                        count++;
                    }
                }
                start++;
            }
        }

        return len==Integer.MAX_VALUE?"":res;
    }
}
