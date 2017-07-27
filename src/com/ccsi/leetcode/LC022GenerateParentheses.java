package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/7/26.
 */
public class LC022GenerateParentheses {
    public static void main(String[] args) {
        List<String> res=generateParenthesis(3);
        res.forEach(x-> System.out.println(x));
    }
    public static List<String> generateParenthesis(int n){
        List<String> result=new ArrayList<>();
        if(n<1)return result;
        StringBuilder curr=new StringBuilder();
        helper(n,0,0,curr,result);
        return result;
    }
    //Combination
    private static void helper(int n,int left,int right,StringBuilder curr,List<String> result){
        if(left==n&&right==n){
            result.add(curr.toString());
            return;
        }
        //只要"("的数量没有超过n，都可以插入"("。
        if(left<n){
            curr.append('(');
            helper(n,left+1,right,curr,result);
            curr.deleteCharAt(curr.length()-1);
        }
        //而可以插入")"的前提则是当前的"("数量必须要多余当前的")"数量。
        if(right<left){
            curr.append(')');
            helper(n,left,right+1,curr,result);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
