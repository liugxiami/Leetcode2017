package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/2/3.
 */
public class LC316RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s="cbacdcbc";
        System.out.println(removeDuplicateLetters1(s));
    }
    public static String removeDuplicateLetters(String s){
        if(s==null||s.length()==0)return s;
        int len=s.length();
        int[] counts=new int[26];

        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            counts[c-'a']++;
        }

        int pos=0;
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(c<s.charAt(pos)){
                pos=i;
            }
            counts[c-'a']--;
            if(counts[c-'a']==0)break;
        }

        String toBeRemoveLetter=String.valueOf(s.charAt(pos));
        return toBeRemoveLetter+removeDuplicateLetters(s.substring(pos+1)).replaceAll(toBeRemoveLetter,"");
    }

    //method2
    public static String removeDuplicateLetters1(String s){
        int n = s.length();
        if (n < 2) return s;
        StringBuilder result = new StringBuilder();
        int[] count=new int[26];
        boolean[] visit=new boolean[26];
        for (int i = 0; i < n; ++i) ++count[s.charAt(i) - 'a'];
        for (int j = 0; j < n; ++j)
        {
            char c=s.charAt(j);
            --count[c - 'a'];
            if (visit[c - 'a']) continue;
            while (!result.toString().isEmpty() && result.charAt(result.length()-1) > c
                    && count[result.charAt(result.length()-1) - 'a'] > 0)
            {
                visit[result.charAt(result.length()-1) - 'a'] = false;
                result.deleteCharAt(result.length()-1);
            }
            result.append(c);
            visit[c - 'a'] = true;
        }
        return result.toString();
    }
}
