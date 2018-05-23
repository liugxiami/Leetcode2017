package com.ccsi.leetcode4;

import java.util.*;

/**
 * Created by gxliu on 2018/5/22.
 */
public class LC412FizzBuzz {
    public static void main(String[] args) {
        List<String> res=fizzBuzz(15);
        res.forEach(x-> System.out.println(x));
    }
    public static List<String> fizzBuzz(int n){
        List<String> result=new ArrayList<>();
        if(n<=0)return result;
        for (int i = 1; i <=n; i++) {
            if(i%3==0&&i%5==0)result.add("FizzBuzz");
            else if(i%3==0)result.add("Fizz");
            else if(i%5==0)result.add("Buzz");
            else result.add(String.valueOf(i));
        }
        return result;
    }
}
