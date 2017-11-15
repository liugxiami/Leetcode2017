package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/14.
 */
public class LC139WordBreak {
    public static void main(String[] args) {
        String s="leetcode";
        List<String> wordList=new ArrayList<>();
        wordList.add("leet");
        wordList.add("code");

        System.out.println(wordBreak(s,wordList));
    }
    //方法：用DP. 比用DFS+循环省时省力。
    //状态方程，0<j<i,DP[k]为真并且Dict.contains（s.substring(k,i)）
    public static boolean wordBreak(String s,List<String> wordDict){
        if(s==null||s.length()==0)return false;
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;   //初始化
        Set<String> set=new HashSet<>();
        set.addAll(wordDict);

        for (int i = 0; i <= len; i++) { //因为substring（start，end）是左闭右开区间，所以要<=len.
            for (int j = i; j >=0 ; j--) {
                if(i-j>0&&dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
