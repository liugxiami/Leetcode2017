package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/5/13.
 */
public class LC402RemoveKDigits {
    public static void main(String[] args) {
        String num="123";
        System.out.println(removeKdigits(num,3));
    }
    /*
    建立一个栈stack.

    for从nums[0]开始循环扫描到末尾（或0 == k时）
        while栈顶元素 > num[i]（大概的意思就是把较高位中比较大的数移除），pop()栈顶元素，top--，k--（需要移除个数减一）
        （一直while直到条件不满足）
        每次for无论什么情况，最后都push(num[i])
    最后将stack转成string，并移除前导0.
     */
    public static String removeKdigits(String num,int k){
        int len=num.length();

        Stack<Character> stack=new Stack<>();

        for (int i = 0; i < len; i++) {
            char c=num.charAt(i);
            while(k>0&&!stack.isEmpty()&&stack.peek()-'0'>c-'0'){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        //如果数是一直增大的话，有可能循环完了但没pop够，需要尾处理一下。
        while(k>0&&!stack.isEmpty()){
            stack.pop();
            k--;
        }

        //移除前导0，
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String res=sb.reverse().toString();
        int start=0;
        while(start<res.length()&&res.charAt(start)=='0')start++; //注意还要判断start不能大于len
        return start==res.length()?"0":res.substring(start);
    }
}
