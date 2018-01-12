package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2018/1/11.
 */
public class LC301RemoveInvalidParentheses {
    public static void main(String[] args) {
        String s="(a)())()";
        List<String> res=removeInvalidParentheses(s);
        res.forEach(x-> System.out.println(x));
    }
    public static List<String> removeInvalidParentheses(String s){
        List<String> result=new ArrayList<>();
        if(s==null||s.length()==0)return result;
        int len=s.length();
        int left=0; //可以被删除的左括号数目
        int right=0;//可以被删除的右括号数目
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(c=='(')left++;
            else if(c==')'){
                if(left>0)left--;
                else right++;
            }
        }
        Set<String> set=new HashSet<>();
        helperDFS(set,s,0,new StringBuilder(),left,right,0);
        result.addAll(set);
        return result;
    }
    public static void helperDFS(Set<String> result,String s,int index,StringBuilder sb,
                                 int left,int right,int open){
        if(left<0||right<0||open<0)return;
        //因为题目要求remove minimum invalid parenteses，所以left和right不能小于0，open是指配对情况，
        //配对的话为0，否则不为0，小于0说明还有左括号未配对，大于0说明还有右括号未配对。
        if(index==s.length()){
            if(open==0)result.add(sb.toString());
            return; //无论是否配对完，都需要return，所以这里的内if不能和外if合并。
        }

        //Backtracking来看每一个字符是否放进去，对于'('和')'来说，有两种情况，放或者不放，会影响到left和right
        //及open的值，但如果是其他情况，则只有一种情况，放进去。
        char c=s.charAt(index);
        if(c=='('){
            helperDFS(result,s,index+1,sb,left-1,right,open);
            helperDFS(result,s,index+1,sb.append('('),left,right,open+1);
        }else if(c==')'){
            helperDFS(result,s,index+1,sb,left,right-1,open);
            helperDFS(result,s,index+1,sb.append(')'),left,right,open-1);
        }else{
            helperDFS(result,s,index+1,sb.append(c),left,right,open);
        }
        sb.deleteCharAt(sb.length()-1); //BT,remove last char of sb.
    }
}
