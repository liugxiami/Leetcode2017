package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/9.
 */
public class LC211AddAndSearchWord {
    private class TrieNode {
        Character character;
        Map<Character,TrieNode> children;
        boolean isWord;

        public TrieNode(){
            this.children=new HashMap<>();
        }
    }
    private TrieNode dummyHead;
    public LC211AddAndSearchWord(){
        dummyHead=new TrieNode();
    }

    public void addWord(String word){
        if(word==null||word.length()==0)return;
        int len=word.length();
        TrieNode curr=dummyHead;
        for (int i = 0; i < len; i++) {
            char c=word.charAt(i);
            if(curr.children.isEmpty()||!curr.children.containsKey(c)){
                TrieNode temp=new TrieNode();
                temp.character=c;
                curr.children.put(c,temp);
            }
            curr=curr.children.get(c);
        }
        curr.isWord=true;
    }

    public boolean search(String word){
        if(word==null||word.length()==0)return false;
        TrieNode curr=dummyHead;
        return helper(curr,word,0);
    }
    //递归。因为返回的是boolean，在递归过程中，只有当找到了才返回true，其他在寻找过程中，在某些路径中没找到的情况下，不直接
    //返回（比如下面的循环中，没找到的情况下就继续寻找（并不返回false），找到了就return true）。如果所有可能途径都找过了，还是没
    //找到，也就是在循环结束之后，这是才返回false。
    private boolean helper(TrieNode curr, String word, int index){
        //这里的curr传进来时都不会为空，判断过了。
        if(index==word.length()){ //index到头了，判断一下
            return curr.isWord;
        }

        char c=word.charAt(index); //否则就看看当前这个char
        if(c=='.'){   //这个char有两种情况，一是'.',另一种是a-z
            for(char ch:curr.children.keySet()){
                if(helper(curr.children.get(ch),word,index+1))return true;//必须用if语句，直接return
                //helper(curr.children.get(ch),word,i+1))不行。因为直接return的话，一旦返回就结束了，其他的路径
                //就不能再继续找了，if语句的话，只返回找到了的情况，如果当前这条路上没找到，就继续下一条找。
            }
            return false;
        }else{
            //是字符的情况下，又有两种情况，一是这个字符在children中，一是不在。在的话，递归继续找，否则返回false。
            if(curr.children.containsKey(c)) return helper(curr.children.get(c),word,index+1);
            else return false;
        }
    }

    public static void main(String[] args) {
        LC211AddAndSearchWord wordDict=new LC211AddAndSearchWord();
        wordDict.addWord("at");
        wordDict.addWord("and");
        //wordDict.addWord("an");
        wordDict.addWord("add");
        wordDict.addWord("bat");
        wordDict.addWord("a");

        System.out.println(wordDict.search("a."));
    }
}
