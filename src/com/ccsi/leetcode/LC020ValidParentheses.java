package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/7/25.
 */
public class LC020ValidParentheses {
    public static void main(String[] args) {
        String s="(aa{3)b[c}c]{dd}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s){
        if(s==null||s.length()==0)return true;
        Stack<Character> stack=new Stack<>();
        int len=s.length();
        char[] chars=s.toCharArray();
        for (int i = 0; i < len; i++) {
            char c=chars[i];
            if(c==')'||c=='}'||c==']'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    char temp=stack.pop();
                    if(!isMatch(temp,c))return false;
                }
            }
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    private static boolean isMatch(char first,char second){
        return (first=='('&&second==')')||(first=='['&&second==']')||(first=='{'&&second=='}');
    }
}
