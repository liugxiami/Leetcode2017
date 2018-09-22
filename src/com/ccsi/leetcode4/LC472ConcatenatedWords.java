package com.ccsi.leetcode4;

import java.util.*;

public class LC472ConcatenatedWords {
    public static void main(String[] args) {
        String[] words={"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> res=findAllConcatenatedWordsInADict1(words);
        res.forEach(word-> System.out.println(word));
    }
    //method 1 DP 超时
    public static List<String> findAllConcatenatedWordsInADict(String[] words){
        List<String> results=new ArrayList<>();
        if(words==null||words.length==0)return results;
        Set<String> set=new HashSet<>();
        for(String word:words)set.add(word);
        for (int i = 0; i < words.length; i++) {
            if(canBeSplit(words[i],set))results.add(words[i]);
        }
        return results;
    }
    //DP
    private static boolean canBeSplit(String word,Set<String> set){
        if(word==null||word.length()==0)return false;
        boolean[] dp=new boolean[word.length()+1];
        dp[0]=true;
        for (int i = 0; i <= word.length(); i++) {
            for (int j = i; j >=0 ; j--) {
                if(i>j&&dp[j]&&set.contains(word.substring(j,i))&&!(i==word.length()&&j==0)){
                    dp[i]=true;
                }
            }
        }
        return dp[word.length()];
    }
    //method2 Trie Node
    static TrieNode root=new TrieNode();
    public static List<String> findAllConcatenatedWordsInADict1(String[] words){
        List<String> result=new ArrayList<>();
        if(words==null||words.length==0)return result;
        buildTree(words);
        for (int i = 0; i < words.length; i++) {
            if(search(words[i],0,0))result.add(words[i]);
        }
        return result;
    }
    private static void buildTree(String[] words){
        for (int i = 0; i < words.length; i++) {
            String word=words[i];
            TrieNode curr=root;
            if(word==null||word.length()==0)continue;
            for (int j = 0; j < word.length(); j++) {
                if(curr.children[word.charAt(j)-'a']==null){
                    curr.children[word.charAt(j)-'a']=new TrieNode();
                }
                curr=curr.children[word.charAt(j)-'a'];
            }
            curr.isWord=true;
        }
    }
    private static boolean search(String word,int index,int counts){
        TrieNode curr=root;
        int i=index;
        for (; i < word.length(); i++) {
            if(curr.children[word.charAt(i)-'a']==null)return false;
            curr=curr.children[word.charAt(i)-'a'];
            if(curr.isWord&&search(word,i+1,counts+1))return true;
        }
        return curr.isWord&&counts>=1;
    }
}
class TrieNode{
    boolean isWord;
    TrieNode[] children;
    public TrieNode(){
        this.isWord=false;
        children=new TrieNode[26];
    }
}
