package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/3/12.
 */
public class LC336PalindromePairs {
    public static void main(String[] args) {
        String[] words={"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> res=palindromePairs1(words);

    }
    //method1 brute force
    public static List<List<Integer>> palindromePairs(String[] words){
        List<List<Integer>> result=new ArrayList<>();
        if(words==null||words.length<2)return result;
        int len=words.length;

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                String newWord1=words[i]+words[j];
                String newWord2=words[j]+words[i];
                if(isPalindrome(newWord1)){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
                if(isPalindrome(newWord2)){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(j);
                    temp.add(i);
                    result.add(temp);
                }
            }
        }
        return result;
    }
    private static boolean isPalindrome(String word){
        if(word==null||word.length()<2)return true;
        int len=word.length();
        int p=0,q=len-1;
        word=word.toLowerCase();
        while(p<q){
            while(p<len&&!Character.isLetterOrDigit(word.charAt(p)))p++;
            while(q>=0&&!Character.isLetterOrDigit(word.charAt(q)))q--;

            if(p<q&&word.charAt(p)==word.charAt(q)){
                p++;
                q--;
            }else return false;
        }
        return true;
    }
    //method2 hashMap
    public static List<List<Integer>> palindromePairs1(String[] words){
        List<List<Integer>> result=new ArrayList<>();
        if(words==null||words.length<2)return result;
        int size=words.length;

        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put(words[i],i);
        }

        for (int i = 0; i < size; i++) {
            String curr=words[i];

            //case 1 两个word一样长并且对称
            String reverseCurr=new StringBuilder(curr).reverse().toString();
            if(map.containsKey(reverseCurr)&&map.get(reverseCurr)!=i){
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                temp.add(map.get(reverseCurr));
                result.add(temp);
            }
            //case 2 自己就是对称的，同时还有一个空字符串。
            if(isPalindrome(curr)&&map.containsKey("")&&map.get("")!=i){
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                temp.add(map.get(""));
                result.add(temp);

                temp=new ArrayList<>();
                temp.add(map.get(""));
                temp.add(i);
                result.add(temp);
            }
            //case 3 一个长字符串，从第一个开始进行切割成left和right字符串，如果其中之一是对称的，那么将另外一半逆反
            int len=curr.length();
            for (int j = 1; j < len; j++) {
                String left=curr.substring(0,j);
                String right=curr.substring(j);
                //left是对称的，那么逆反right
                if(isPalindrome(left)){
                    String reverseRight=new StringBuilder(right).reverse().toString();
                    if(map.containsKey(reverseRight)&&map.get(reverseRight)!=i){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(map.get(reverseRight));
                        temp.add(i);
                        result.add(temp);
                    }
                }
                //right是对称的，那么逆反left
                if(isPalindrome(right)){
                    String reverseLeft=new StringBuffer(left).reverse().toString();
                    if(map.containsKey(reverseLeft)&&map.get(reverseLeft)!=i){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(i);
                        temp.add(map.get(reverseLeft));
                        result.add(temp);
                    }
                }
            }
        }
        return result;
    }
}
