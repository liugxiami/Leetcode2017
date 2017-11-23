package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/21.
 */
public class LC150EvaluateReversePolishNotation {
    public static void main(String[] args) {
        //String[] tokens={"2", "1", "+", "3", "*"};
        String[] tokens={"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens){
        if(tokens==null||tokens.length==0)return -1;
        Stack<Integer> stack=new Stack<>();
        for(String token:tokens){
            if(isOperator(token)){
                int[] nums=new int[2];
                if(!stack.isEmpty()){
                    nums[1]=stack.pop();
                }else return -1;

                if(!stack.isEmpty()){
                    nums[0]=stack.pop();
                }else return -1;

                switch (token){
                    case "+":
                        stack.push(nums[0]+nums[1]);break;
                    case "-":
                        stack.push(nums[0]-nums[1]);break;
                    case "*":
                        stack.push(nums[0]*nums[1]);break;
                    case "/":
                        if(nums[1]==0){
                            return -1;
                        }else{
                            stack.push(nums[0]/nums[1]);
                        }
                        break;
                }
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        int result=stack.pop();
        return stack.isEmpty()?result:-1;
    }
    private static boolean isOperator(String str){
        return str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/");
    }
}
