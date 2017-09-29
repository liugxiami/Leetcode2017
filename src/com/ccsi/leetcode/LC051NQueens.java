package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/9/25.
 */
public class LC051NQueens {
    public static void main(String[] args) {
        List<List<String>> res=solveNQueens(8);
        for (int i = 0; i < res.size(); i++) {
            res.get(i).forEach(x-> System.out.print(x+" "));
            System.out.println(i);
            System.out.println();
        }
    }
    public static List<List<String>> solveNQueens(int n){
        List<List<String>> result=new ArrayList<>();
        if(n<=0)return result;

        helper(result,new Stack<>(),n); //bt来做
        return result;
    }
    private static void helper(List<List<String>> result,Stack<Integer> stack,int n){
        if(stack.size()==n){
            result.add(makeGraph(stack)); //将stack转换一下加进result。
            return;
        }

        for (int col = 0; col < n; col++) {
            if(isValid(stack,col)){              //和排列组合的很相似，数独的也很相似
                stack.push(col);
                helper(result,stack,n);
                stack.pop();
            }
        }
    }
    private static boolean isValid(Stack<Integer> stack, int col){
        for (int i = 0; i < stack.size(); i++) {
            if(stack.get(i)==col)return false;
            if(stack.size()-i==col-stack.get(i))return false;   //左上，之所以这里不是用size-1，因为当前判断的这个是还没加进
                                                                //stack的未来的元素。
            if(stack.size()-i==stack.get(i)-col)return false;   //左下
        }
        
        return true;
    }
    
    private static List<String> makeGraph(Stack<Integer> stack){
        List<String> result=new ArrayList<>();
        for (int i = 0; i < stack.size(); i++) {
            StringBuilder str=new StringBuilder();
            for (int j = 0; j < stack.size(); j++) {
                str.append((j==stack.get(i))?'Q':'.');
            }
            result.add(str.toString());
        }
        return result;
    }
}
