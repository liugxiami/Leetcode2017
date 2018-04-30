package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/26.
 */
public class LC394DecodeString {
    public static void main(String[] args) {
        String s="2[abc]3[cd]ef";
        System.out.println(decodeString1(s));
    }
    /*
    迭代的方法，当然需要用stack来辅助运算，我们用两个stack，一个用来保存个数，一个用来保存字符串，
    我们遍历输入字符串，如果遇到数字，我们更新计数变量cnt；如果遇到左中括号，我们把当前cnt压入数字栈中，把
    当前result压入字符串栈中；如果遇到右中括号时，我们取出数字栈中顶元素，存入变量repeat，然后给字符串栈的顶元素
    temp循环加上repeat个t字符串，然后将temp存入result中；如果遇到字母，我们直接加入字符串result中即可
     */
    public static String decodeString(String s){
        String result="";
        if(s==null||s.length()==0)return result;
        int len=s.length();
        Stack<Integer> repeats=new Stack<>();
        Stack<String> strings=new Stack<>();

        int cnt=0;
        for (int i = 0; i < len; i++) {
            char curr=s.charAt(i);
            if(curr>='0'&&curr<='9'){
                cnt=cnt*10+curr-'0'; //计算重复次数
            }else if(curr=='['){
                repeats.push(cnt);
                strings.push(result);
                result=""; //入栈之后，result清空
                cnt=0; //cnt也恢复为0
            }else if(curr==']'){
                int repeat=repeats.pop();
                String temp=strings.pop();
                for (int j = 0; j < repeat; j++) {
                    temp+=result;
                }
                result=temp;
            }else{
                result+=s.charAt(i);
            }
        }
        return result;
    }
    //method2 recursion
    public static String decodeString1(String s){
        if(s==null||s.length()==0)return "";
        int[] i={0}; //用一个引用类型的参数来传递，不用基本类型
        return decode(s,i);
    }
    private static String decode(String s,int[] index){
        String result="";
        while (index[0] < s.length()&&s.charAt(index[0])!=']') {
            char c=s.charAt(index[0]);

            if(c<'0'||c>'9'&&c!='['){
                result+=c;
                index[0]++;
            }else {
                int cnt=0;
                while (index[0]<s.length()&&c>='0'&&c<='9') {
                    cnt = cnt * 10 + c - '0';
                    index[0]++;
                    c=s.charAt(index[0]);
                }
                index[0]++;//'['
                String str=decode(s,index);
                index[0]++;//']'
                while(cnt-->0)result+=str;
            }
        }
        return result;
    }
}
