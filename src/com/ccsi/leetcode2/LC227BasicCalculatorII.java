package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/18.
 */
public class LC227BasicCalculatorII {
    public static int calculator(String s){
        if(s==null||s.length()==0)return 0;
        Stack<Integer> stack=new Stack<>();
        int len=s.length();

        int num=0;   //保存当前数值
        int preOperator='+'; //用来保存前一个操作符。初始化为+。

        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if(c>='0'&&c<='9'){
                num=num*10+c-'0';
            }
            //当前为运算符合或到最后结尾了，根据前一个运算符来进行计算或直接入栈。
            if(c=='+'||c=='-'||c=='*'||c=='/'||i==len-1){ //如果是加减乘除或到最后了一位了，那么就看看前面一个操作符是什么。
                if(preOperator=='+')stack.push(num); //如果前一个操作符是+，那就直接入栈
                else if(preOperator=='-')stack.push(-num); //如果前一个操作符是-，相反数入栈。
                else if(preOperator=='*'||preOperator=='/'){ //如果前一个操作符是*或/，出栈和当前这个数计算，结果入栈。
                    stack.push(preOperator=='*'?stack.pop()*num:stack.pop()/num);
                }
                preOperator=c; //更新前一操作符
                num=0; //num使用完毕，更新为0，准备下一次取值。
            }
        }

        int result=0;
        while(!stack.isEmpty()){  //将stack里面的数相加，其中本来的减好以相反数的形式来做了。
            result+=stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String s=" 3+15 / 2+2*3 ";
        System.out.println(calculator(s));
    }
}
