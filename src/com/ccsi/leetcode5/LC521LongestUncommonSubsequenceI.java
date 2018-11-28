package com.ccsi.leetcode5;

public class LC521LongestUncommonSubsequenceI {
    public static void main(String[] args) {
        System.out.println(findLUSlength("abc","adbfc"));
    }
    /*
    Read carefully:
    The longest uncommon subsequence is defined as the longest subsequence of one of these strings and
    this subsequence should not be any subsequence of the other strings. Which means in your case
    ("abc" and "avbfc"), "avbfc" is subsequence of "avbfc", but not subsequence of "abc",
    thus below code is the right answer.
     */
    public static int findLUSlength(String a,String b){
        return a.equals(b)?-1:Math.max(a.length(),b.length());
    }
}
