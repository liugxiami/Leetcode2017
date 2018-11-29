package com.ccsi.leetcode5;

public class LC522LongestUncommonSubsequenceII {
    public static void main(String[] args) {
        String[] strs={"aabbcc","aabbcc","eg"};
        System.out.println(findLUSlength(strs));
    }
    //双指针，对任何一个字符串与其他的任何一个字符串进行比较，如果是子字符串，跳过，如果不是，更新最长长度。
    public static int findLUSlength(String[] strs){
        if(strs==null||strs.length==0)return -1;
        int len=strs.length;
        int max=-1;
        for (int i = 0; i < len; i++) { //第一个指针
            if(strs[i].length()<max)continue; //剪枝，加快。如果当前的字符串长度小于max，直接跳过，即使这个字符串不
            //是其它字符串的子字符串，也没用。
            int j=-1; //第二个指针
            while(++j<len)if(i!=j&&isSubsequence(strs[i],strs[j]))break; //如果是其他字符串的子字符串，跳出
            if(j==len)max=Math.max(max,strs[i].length()); //如果当前字符串和其他比较到了最后，那么说明它不是其他
            //字符串的子字符串，计算。
        }
        return max;
    }
    private static boolean isSubsequence(String a,String b){
        int j=0;
        for (int i = 0; i < b.length(); i++) {
            if(j<a.length()&&a.charAt(j)==b.charAt(i))j++;
            if(j==a.length())break;
        }
        return j==a.length();
    }
}
