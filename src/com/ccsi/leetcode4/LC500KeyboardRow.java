package com.ccsi.leetcode4;

import java.util.*;

public class LC500KeyboardRow {
    public static void main(String[] args) {
        String[] words={"Hello","Alaska","Dad","Peace"};
        String[] result=findWords(words);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static String[] findWords(String[] words){
        if(words==null||words.length==0)return new String[0];

        String[] letters=new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
        List<String> result=new ArrayList<>();

        for(String word:words){
            int row=0;
            boolean sameRow=true;
            if(letters[1].indexOf(word.toLowerCase().charAt(0))>=0)row=1;//巧妙利用indexOf，不存在返回-1.
            if(letters[2].indexOf(word.toLowerCase().charAt(0))>=0)row=2;
            for(char c:word.toLowerCase().toCharArray()){
                if(letters[row].indexOf(c)<0){
                    sameRow=false;
                    break;
                }
            }
            if(sameRow)result.add(word);
        }
        return result.toArray(new String[result.size()]);
    }
}
