package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/7/24.
 */
public class LC017LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits="345";
        List<String> LB=letterCombinations(digits);
        LB.forEach(x-> System.out.print(x+" "));
    }
    public static List<String> letterCombinations(String digits){
        List<String> result=new ArrayList<>();  //存储结果
        if(digits==null||digits.length()==0)return result;

        String[] dic={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder curr=new StringBuilder();  //相当于stack，存储当前组合
        int len=digits.length();
        helper(digits,0,len,dic,curr,result);  //BT
        return result;
    }
    //BT的通用套路，这是用来求全组合。
    private static void helper(String digits,int index,int length,String[] dic,StringBuilder curr,List<String> result){
        if(index>=length){
            result.add(curr.toString());
            return;
        }

        int num=digits.charAt(index)-'0';
        for (int i = 0; i < dic[num].length(); i++) {
            curr.append(dic[num].charAt(i));
            helper(digits,index+1,length,dic,curr,result);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
