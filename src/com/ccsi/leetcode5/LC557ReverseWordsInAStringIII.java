package com.ccsi.leetcode5;

public class LC557ReverseWordsInAStringIII {
    public static void main(String[] args) {
        String s="Let's take Leetcode contest";
        System.out.println(reverseWord(s));
    }
    public static String reverseWord(String s){
        if(s==null||s.length()<2)return s;
        String[] strings=s.split(" ");
        for(int i=0;i<strings.length;i++){
            strings[i]=new StringBuilder(strings[i]).reverse().toString();
        }
        StringBuilder sb=new StringBuilder();
        for(String str:strings){
            sb.append(str+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
