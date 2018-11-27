package com.ccsi.leetcode5;

public class LC520DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("llKll"));
    }
    public static boolean detectCapitalUse(String word){
        if(word==null||word.length()==0)return true;
        char[] chars=word.toCharArray();
        boolean firstCap=false;
        if(isCapital(chars[0]))firstCap=true;
        for (int i = 1; i < word.length(); i++) {
            if(firstCap){
                if(i!=1&&(isCapital(chars[i-1])&&!isCapital(chars[i]))||(!isCapital(chars[i-1])&&isCapital(chars[i])))return false;
            }else{
                if(isCapital(chars[i]))return false;
            }
        }
        return true;
    }
    private static boolean isCapital(char c){
        if(c>='A'&&c<='Z')return true;
        else return false;
    }
}
