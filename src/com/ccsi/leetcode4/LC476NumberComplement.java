package com.ccsi.leetcode4;

import java.util.*;

public class LC476NumberComplement {
    public static void main(String[] args) {
        System.out.println(findComplement1(1));
    }
    //method 1 stack
    public static int findComplement(int num){
        Stack<Integer> stack=new Stack<>();
        while(num>0){
            if((num&1)==1)stack.push(0);
            else stack.push(1);
            num>>=1;
        }
        int result=0;
        while(!stack.isEmpty()){
            result=result*2+stack.pop();
        }
        return result;
    }
    //method2 bit manipulation
    public static int findComplement1(int num){
        int bits=0; //先计算出num的二进制上的位数
        int result=0;
        int temp=num; //开始这边直接用了num，导致下面要用num时变成了0.
        while(temp>0){
            bits++;
            temp>>=1;
        }

        for (int i = bits-1; i >=0 ; i--) { //算出位数是为了用左到右的进行计算方便，int数有32为，再前面的0就可以不用考虑了。
            if((num&(1<<i))==0)result=result|(1<<i);
        }

        return result;
    }
}
