package com.ccsi.leetcode4;

import java.util.Iterator;

/**
 * Created by gxliu on 2018/7/15.
 */
public class LC443StringCompression {
    public static void main(String[] args) {
        char[] chars={'a','a','b','b','c','c','c'};
        System.out.println(compress2(chars));
    }
    //method 1 note in-place
    public static int compress(char[] chars){
        if(chars==null||chars.length<=1)return chars.length;
        StringBuilder sb=new StringBuilder();
        int repeat=1;
        char pre=chars[0];
        for (int i = 1; i < chars.length; i++) {
            char curr=chars[i];
            if(pre==curr)repeat++;
            else{
                sb.append(pre);
                if(repeat>1)sb.append(repeat);
                pre=curr;
                repeat=1;
            }

            if(i==chars.length-1){
                sb.append(pre);
                if(repeat>1)sb.append(repeat);
            }
        }
        System.out.println(sb.toString());
        return sb.length();
    }
    //method 2
    public static int compress1(char[] chars){
        if(chars==null||chars.length<=1)return chars.length;
        int count=0;
        int repeat=1;
        char pre=chars[0];
        for (int i = 1; i < chars.length; i++) {
            char curr=chars[i];
            if(pre==curr)repeat++;
            else{
                count++;
                if(repeat>1){
                    while(repeat>0){
                        count++;
                        repeat/=10;
                    }
                }
                pre=curr;
                repeat=1;
            }

            if(i==chars.length-1){
                count++;
                if(repeat>1){
                    while(repeat>0){
                        count++;
                        repeat/=10;
                    }
                }
            }
        }

        return count;
    }
    //method 3
    public static int compress2(char[] chars){
        if(chars==null||chars.length<=1)return chars.length;
        int index=0;
        int repeat=1;
        char pre=chars[0];
        for (int i = 1; i < chars.length; i++) {
            char curr=chars[i];
            if(pre==curr)repeat++;
            else{
                chars[index++]=pre;
                if(repeat>1){
                    String str=String.valueOf(repeat);
                    for(char c:str.toCharArray()){
                        chars[index++]=c;
                    }
                }
                pre=curr;
                repeat=1;
            }

            if(i==chars.length-1){
                chars[index++]=pre;
                if(repeat>1){
                    String str=String.valueOf(repeat);
                    for(char c:str.toCharArray()){
                        chars[index++]=c;
                    }
                }
            }
        }
        return index;
    }
}
