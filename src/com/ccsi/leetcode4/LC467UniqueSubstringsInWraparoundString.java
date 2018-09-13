package com.ccsi.leetcode4;

import java.util.*;

public class LC467UniqueSubstringsInWraparoundString {
    public static void main(String[] args) {
        String p="zabd";
        System.out.println(findSubstringInWraproundString(p));
    }
    /*DP,
    1. The max number of unique substring ends with a letter equals to the length of max contiguous
    substring ends with that letter. Example "abcd", the max number of unique substring ends with
    'd' is 4, apparently they are "abcd", "bcd", "cd" and "d".
    2. If there are overlapping, we only need to consider the longest one because it covers all
    the possible substrings. Example: "abcdbcd", the max number of unique substring ends with 'd'
    is 4 and all substrings formed by the 2nd "bcd" part are covered in the 4 substrings already.
    3.No matter how long is a contiguous substring in p, it is in s since s has infinite length.
    4.Now we know the max number of unique substrings in p ends with 'a', 'b', ..., 'z' and those
    substrings are all in s. Summary is the answer, according to the question.

    比如："abcdbcd"
    i=0 a              maxcount=1; count[0]=1;
    i=1 ab+b           maxcount=2; count[1]=2;   i=4 b         maxcount=1(归为1) count[1]=2(因为2>maxount)
    i=2 abc+bc+c       maxcount=3; count[2]=3;   i=5 bc+c      maxcount=2       count[2]=3;
    i=3 abcd+bcd+cd+d  maxcount=4  count[3]=4;   i=6 bcd+cd+d  maxcount=3       count[3]=4;
    最终结果为1+2+3+4=10；

     */
    public static int findSubstringInWraproundString(String p){
        if(p==null||p.length()==0)return 0;
        int[] counts=new int[26];
        int maxCount=0;
        for (int i = 0; i < p.length(); i++) {
            if(i>0&&(p.charAt(i)==p.charAt(i-1)+1||p.charAt(i)==p.charAt(i-1)-25)){
                maxCount++;
            }else maxCount=1;

            int index=p.charAt(i)-'a';
            counts[index]=Math.max(maxCount,counts[index]);
        }
        int count=0;
        for (int c:counts) {
            count+=c;
        }
        return count;
    }

}
