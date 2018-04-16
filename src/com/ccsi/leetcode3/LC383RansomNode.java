package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/15.
 */
public class LC383RansomNode {
    public static void main(String[] args) {
        String ran="aa";
        String magazine="ab";
        System.out.println(canConstruct(ran,magazine));
    }
    public static boolean canConstruct(String ransomeNotes,String magazine){
        if(ransomeNotes==null||ransomeNotes.length()==0)return true;
        if(magazine==null||magazine.length()==0)return false;
        if(ransomeNotes.length()>magazine.length())return false;

        int[] bitMap=new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            bitMap[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomeNotes.length(); i++) {
            bitMap[ransomeNotes.charAt(i)-'a']--;
            if(bitMap[ransomeNotes.charAt(i)-'a']<0)return false;
        }

        return true;
    }
}
