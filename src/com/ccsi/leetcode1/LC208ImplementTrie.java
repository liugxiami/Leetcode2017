package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/7.
 */
public class LC208ImplementTrie {
    private class Node{
        char c;
        Map<Character,Node> next;
        String str;
        public Node(){
            this.next=new HashMap<>();
            str="";
        }
    }
    private Node dummyHead;
    public LC208ImplementTrie(){
        dummyHead=new Node();
    }

    public void insert(String word){
        if(word==null||word.length()==0)return;

        Node curr=dummyHead;
        for (int i = 0; i < word.length(); i++) {
            char temp=word.charAt(i);
            if(curr.next.isEmpty()||!curr.next.containsKey(temp)){
                Node n=new Node();
                n.c=temp;
                curr.next.put(temp,n);
            }
            curr=curr.next.get(temp);
        }
        curr.str=word;
    }

    public boolean search(String word){
        if(word==null||word.length()==0)return false;
        Node curr=dummyHead;
        for (int i = 0; i < word.length(); i++) {
            char temp=word.charAt(i);
            if(curr.next.isEmpty()||!curr.next.containsKey(temp))return false;
            curr=curr.next.get(temp);
        }
        if(curr.str.equals(word))return true;
        return false;
    }

    public boolean startWith(String prefix){
        if(prefix==null||prefix.length()==0)return false;
        Node curr=dummyHead;
        for (int i = 0; i < prefix.length(); i++) {
            char temp=prefix.charAt(i);
            if(curr.next.isEmpty()||!curr.next.containsKey(temp))return false;
            curr=curr.next.get(temp);
        }
        return true;
    }

    public static void main(String[] args) {
        LC208ImplementTrie trie=new LC208ImplementTrie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("word");
        trie.insert("work");
        trie.insert("hell");
        trie.insert("he");

        System.out.println(trie.search("word"));
    }
}
