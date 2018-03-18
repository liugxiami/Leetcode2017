package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/3/17.
 */
public class LC345ReverseVowelsOfAString {
    public static void main(String[] args) {
        String s="hello";
        System.out.println(reverseVowels(s));
        s="leetcode";
        System.out.println(reverseVowels(s));
    }
    public static String reverseVowels(String s){
        if(s==null||s.length()<=1)return s;
        char[] chars=s.toCharArray();
        int len=s.length();

        int p=0;
        int q=len-1;
        while(p<q){
            while(p<len&&!isVowel(chars[p]))p++;
            while(q>=0&&!isVowel(chars[q]))q--;
            if(p>=q)break;
            char c=chars[p];
            chars[p]=chars[q];
            chars[q]=c;
            p++;
            q--;
        }
        return new String(chars);
    }
    private static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}
