package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/12/10.
 */
public class LC212WordSearchII {
    public List<String> findWords(char[][] board,String[] words){
        List<String> result=new ArrayList<>(); //用来保存结果。
        if(board==null||board.length==0||board[0].length==0||words==null||words.length==0)return result;
        int len=words.length;
        int rowNum=board.length;
        int colNum=board[0].length;

        Trie trie=new Trie(); //用字典树来保存words，因为其有startWith功能，可以用其了及时终止不可能存在的情况。
        for (int i = 0; i < len; i++) {
            trie.insert(words[i]);
        }

        Set<String> res=new HashSet<>(); //本来直接用list来存结果就好了的，但是有时会出现重复的word，改用set来保存。
        for (int row = 0; row < rowNum; row++) {  //从头到尾来一次，主要是为了试探每一个位置开始的可能。
            for (int col = 0; col < colNum; col++) {
                boolean[][] visited=new boolean[rowNum][colNum]; //因为不能重复利用同一个位置的字符
                DFS(res,new StringBuilder(),board,row,col,visited,trie); //BT来做
            }
        }

        result.addAll(res); //将结果放回到list中去，并返回。
        return result;
    }

    //BT，典型的back-tracking的方法。
    private void DFS(Set<String> res,StringBuilder path,char[][] board,int row,int col,
                            boolean[][] visited,Trie trie){
        if(row<0||row>=board.length||col<0||col>=board[0].length
                ||visited[row][col])return; //不可能出现的情况先返回。

        path.append(board[row][col]);  //否者的话就递归，BT
        visited[row][col]=true;

        if(trie.startWith(path.toString())){ //先判断是否可以做为prefix存在，不存在的话就不用递归往下走了
            if(trie.search(path.toString())){ //看看到当前path时，其字符串是否出现在trie中，如果在就放入结果集，并返回。
                res.add(path.toString());
            }
            DFS(res,path,board,row+1,col,visited,trie);
            DFS(res,path,board,row-1,col,visited,trie);
            DFS(res,path,board,row,col+1,visited,trie);
            DFS(res,path,board,row,col-1,visited,trie);
        }

        path.deleteCharAt(path.length()-1);
        visited[row][col]=false;
    }
    //Trie的典型写法。
    private class TrieNode{
        char c;
        Map<Character,TrieNode> children;
        boolean isWord;

        public TrieNode(){
            this.children=new HashMap<>();
        }

        public TrieNode(char c){
            this.c=c;
            this.children=new HashMap<>();
        }
    }
    private class Trie{
        TrieNode dummyHead;
        public Trie(){
            dummyHead=new TrieNode();
        }
        public void insert(String word){
            if(word==null||word.length()==0)return;
            int len=word.length();
            TrieNode curr=dummyHead;
            for (int i = 0; i < len; i++) {
                char c=word.charAt(i);
                if(curr.children.isEmpty()||!curr.children.containsKey(c)){
                    TrieNode temp=new TrieNode(c);
                    curr.children.put(c,temp);
                }
                curr=curr.children.get(c);
            }
            curr.isWord=true;
        }
        public boolean search(String word){
            TrieNode curr=searchTrieNode(word);
            return curr!=null&&curr.isWord;
        }
        public boolean startWith(String word){
            TrieNode curr=searchTrieNode(word);
            return curr!=null;
        }
        //因为search和startWith有很大的重复部分，将重复部分写成searchTrieNode。
        public TrieNode searchTrieNode(String word){
            if(word==null||word.length()==0)return null;
            int len=word.length();
            TrieNode curr=dummyHead;
            for (int i = 0; i < len; i++) {
                char c=word.charAt(i);
                if(curr.children.isEmpty()||!curr.children.containsKey(c))return null;
                curr=curr.children.get(c);
            }
            return curr;
        }
    }
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] word={"oath","pea","eat","rain"};
//        char[][] board={{'a'}};
//        String[] word={"a"};
        LC212WordSearchII searchII=new LC212WordSearchII();
        List<String> res=searchII.findWords(board,word);
        res.forEach(x-> System.out.println(x));
    }
}
