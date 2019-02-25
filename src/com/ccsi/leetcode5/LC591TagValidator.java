package com.ccsi.leetcode5;

import java.util.*;

public class LC591TagValidator {
    public static void main(String[] args) {
        String code="<TRUe><![CDATA[123123]]]]><![CDATA[>123123]]></TRUe>";
        System.out.println(isValid(code));
    }
    public static boolean isValid(String code){
        Stack<String> stack=new Stack<>();
        for (int i = 0; i < code.length(); ) { //i++不能用在此处，下面对i的变化有要求
            if(i>0&&stack.isEmpty())return false;
            if(code.startsWith("<![CDATA[",i)){
                int j=i+9;
                i=code.indexOf("]]>",j);
                if(i<0)return false;
                i+=3;
            }else if(code.startsWith("</",i)){
                int j=i+2;
                i=code.indexOf(">",j);
                if(i<0||i==j||i-j>9)return false;
                for (int k = j; k < i; k++) {
                    if(!Character.isUpperCase(code.charAt(k)))return false;
                }
                String tag=code.substring(j,i++);
                if(stack.isEmpty()||!stack.pop().equals(tag))return false;

            }else if(code.startsWith("<",i)){
                int j=i+1;
                i=code.indexOf(">",j);
                if(i<0||i==j||i-j>9)return false;
                for (int k = j; k < i; k++) {
                    if(!Character.isUpperCase(code.charAt(k)))return false;
                }
                String tag=code.substring(j,i++);
                stack.push(tag);
            }else i++;
        }
        return stack.isEmpty();
    }
}
