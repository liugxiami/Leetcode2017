package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/6/17.
 */
public class LC424LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s="ABAB";
        System.out.println(characterRelpacement(s,2));
    }
    public static int characterRelpacement(String s,int k){
        if(s==null||s.length()==0)return 0;
        int len=s.length();
        if(len<=k)return len;

        int[] counts=new int[26];
        int maxLength=0;
        int start=0;
        int maxCount=0;
        for (int end = 0; end < len; end++) {
            counts[s.charAt(end)-'A']++;
            maxCount=Math.max(maxCount,counts[s.charAt(end)-'A']);
            if(maxCount+k<end-start+1){
                counts[s.charAt(start)-'A']--;
                start++;
            }
            maxLength=Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
}
