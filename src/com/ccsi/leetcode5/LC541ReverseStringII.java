package com.ccsi.leetcode5;

public class LC541ReverseStringII {
    public static void main(String[] args) {
        String s="abcdefghij";
        System.out.println(reverseStr1(s,3));
    }
    //method1 自己的方法，beat 7%，慢了
    public static String reverseStr(String s,int k){
        if(s==null||s.length()<2||k==1)return s;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i+=2*k) { //外循环每2k跳
            if(i+2*k<s.length()){ //2*k的n倍之内
                for (int j = 0; j < 2*k; j++) { //对i到i+2k-1之间的字符进行处理
                    if(j<k)sb.append(s.charAt(i+k-1-j)); //i到k-1之间的要颠倒
                    else sb.append(s.charAt(i+j)); //i+k到i+2k-1之间的直接写
                }
            }else if(i+k>s.length()){ //尾余部分，如果是小于k的话
                int count=s.length()-i;
                while(count-->0)sb.append(s.charAt(i+count));
            }else{ //尾余部分，如果是大于等于k的话
                for (int j = 0; j < s.length()-i; j++) {
                    if(j<k)sb.append(s.charAt(i+k-1-j));
                    else sb.append(s.charAt(i+j));
                }
            }
        }
        return sb.toString();
    }
    //method2 参考了discussion, beat 63%
    public static String reverseStr1(String s,int k){
        if(s==null||s.length()<2||k==1)return s;
        char[] chars=s.toCharArray();
        int len=s.length();
        int i=0;
        while(i<len){
            int j=Math.min(i+k-1,len-1);
            SWAP(chars,i,j);
            i+=2*k;
        }
        return String.valueOf(chars);
    }
    private static void SWAP(char[] chars,int i,int j){
        while(i<j){
            char temp=chars[i];
            chars[i++]=chars[j];
            chars[j--]=temp;
        }
    }
}
