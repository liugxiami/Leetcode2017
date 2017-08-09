package com.ccsi.leetcode;

import java.util.Stack;

/**
 * Created by gxliu on 2017/8/4.
 */
public class LC032LongestValidParentheses {
    public static void main(String[] args) {
        String s=")()())()()()((())";
        System.out.println(longestValidParentheses1(s));
    }
    //第一次想到的方法（方法1），用了两个栈，第一个栈用来保存‘（’和‘）’，第二个栈用来保存在栈里的index，结束之后
    //将integer栈里的index看一遍，找到相隔最远的两个index并减1就是了。
    //其实用一个栈就行了，只要碰到'('就入相应的index，碰到')'，分两种情况，stack是空的话就更新start为i+1，否则就
    //pop，更新最长。见方法二。

    //方法1
    public static int longestValidParentheses(String s){
        if(s==null||s.length()<2)return 0;
        Stack<Character> stack=new Stack<>();
        Stack<Integer> indexes=new Stack<>();
        int max=0;
        int i=0;
        for (; i < s.length(); i++) {
            char c2=s.charAt(i);
            if(!stack.isEmpty()&&c2==')'){
                char c1=stack.peek();
                if(isPair(c1,c2)){
                    stack.pop();
                    indexes.pop();
                }else{
                    stack.push(c2);
                    indexes.push(i);
                }
            }else{
                stack.push(c2);
                indexes.push(i);
            }
        }

        int num=i;
        while(!indexes.isEmpty()){
            int pre=indexes.pop();
            max=Math.max(max,num-pre-1);
            num=pre;
        }
        return max;
    }
    private static boolean isPair(char c1,char c2){
        return c1=='('&&c2==')';
    }
    //方法2
    public static int longestValidParentheses1(String s){
        if(s==null||s.length()<2)return 0;
        int len=s.length();

        int max=0;
        int start=0;
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    //start重新开始
                    start=i+1;
                }else{
                    //不为空则pop前一个’（‘
                    int curr=stack.pop();
                    //max=Math.max(max,i-curr+1);
                    //pop出来之后有两种情况，一个是
                    if(stack.isEmpty()){
                        //pop出来后是空的，说明前面被清空过
                        max=Math.max(max,i-start+1);
                    }else{
                        max=Math.max(max,i-stack.peek());
                    }

                }
            }
        }
        return max;
    }
}
