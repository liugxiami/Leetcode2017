package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/7.
 */
public class LC071SimplifyPath {
    public static void main(String[] args) {
        String path="/a/...";
        System.out.println(simplifyPath(path));
    }
    public static String simplifyPath(String path){
        if(path==null||path.length()==0)return "/";
        int len=path.length();

        Stack<String> stack=new Stack<>();

        int lastI=-1;                   //记录上一个‘/’的位置
        for (int i = 0; i < len; i++) {
            if(path.charAt(i)=='/'||i==len-1){
                if(lastI!=-1){           //碰到第一个‘/’时，只更新lastI
                    String curr=(i==len-1&&path.charAt(i)!='/')?path.substring(lastI+1,len):path.substring(lastI+1,i);
                    if(curr.equals("")||curr.equals(".")){  //注意这里是字符串
                        //do nothing                         //不能写continue，因为要跟新lastI
                    }else if(curr.equals("..")){
                        if(!stack.isEmpty()){
                            stack.pop();
                        }
                    }else{
                        stack.push(curr);
                    }
                }
                lastI=i;
            }
        }
        //利于stack重新将path重建起来
        if(stack.isEmpty())return "/";

        StringBuilder result=new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            result.append("/"+stack.get(i));   //非常规的利用了stack
        }
        return result.toString();
    }
}
