package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/14.
 */
public class LC140WordBreakII {
    public static void main(String[] args) {
        String s="catsanddog";
        String[] strings={"cat", "cats", "and", "sand", "dog"};
        //String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        //String[] strings={"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> wordList=Arrays.asList(strings);

        List<String> res=wordBreak(s,wordList);
        res.forEach(x-> System.out.println(x));
    }

    public static List<String> wordBreak(String s,List<String> wordList){
        List<String> result=new ArrayList<>();
        if(s==null||s.length()==0)return result;

        Set<String> set=new HashSet<>();
        set.addAll(wordList);

        if(canBreak(s,set)){  //直接用DFS+循环来做过不了大数组，根据wordBreakI，对超长string先进行判断是否可以break。
            helper(result,new ArrayList<>(),s,0,set);
        }
        return result;
    }
    private static void helper(List<String> result,List<String> list,String s,int index,Set<String> set){
        if(index==s.length()){
            StringBuilder sb=new StringBuilder();
            for(String str:list){
                sb.append(str+' ');
            }
            sb.deleteCharAt(sb.length()-1);

            result.add(sb.toString());
            return;
        }

        for (int i = index; i <= s.length(); i++) {
            String str=s.substring(index,i);
            if(set.contains(str)){
                list.add(str);
                helper(result,list,s,i,set);
                list.remove(list.size()-1);
            }
        }
    }
    private static boolean canBreak(String s,Set<String> set){
        if(s==null||s.length()==0)return false;
        int len=s.length();
        boolean[] dp=new boolean[len+1];
        dp[0]=true;

        for (int i = 0; i <= len; i++) {
            for (int j = i; j >=0; j--) {
                if(i-j>0&&dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
