package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/9/27.
 */
public class LC052NQueensII {
    public static void main(String[] args) {
        int res=totalNQueens(8);
        System.out.println(res);
    }
    public static int counter=0;
    public static int totalNQueens(int n){
        if(n<1)return 0;
        helper(new Stack<Integer>(),n);
        return counter;
    }
    private static void helper(Stack<Integer> stack,int n){
        if(stack.size()==n){
            counter++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isValid(stack,i)){
                stack.push(i);
                helper(stack,n);
                stack.pop();
            }
        }
    }

    private static boolean isValid(Stack<Integer> stack,int col){
        for (int i = 0; i < stack.size(); i++) {
            if(stack.get(i)==col)return false;
            if(stack.size()-i==col-stack.get(i))return false;
            if(stack.size()-i==stack.get(i)-col)return false;
        }
        return true;
    }
}
