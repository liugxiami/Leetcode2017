package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/19.
 */
public class LC388LongestAbsoluteFilePath {
    public static void main(String[] args) {
        String input="dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(lengthLongestPath1(input));
    }
    //map
    public static int lengthLongestPath(String input){
        if(input==null||input.length()==0)return 0;
        Map<Integer,Integer> map=new HashMap<>(); //key为level，value为到目前层级的总长度
        map.put(0,0); //相当于一个dummyHead
        int result=0;

        String[] strings=input.split("\n");
        for(String str:strings){
            int level=str.lastIndexOf("\t")+1;//注意，"\t"只表示一个字符。
            int len=str.substring(level).length();
            if(str.contains(".")){
                result=Math.max(result,map.get(level)+len);
            }else{
                map.put(level+1,map.get(level)+len+1);
            }
        }
        return result;
    }
    //method2 stack
    public static int lengthLongestPath1(String input){
        if(input==null||input.length()==0)return 0;
        Stack<Integer> stack=new Stack<>();//记录相应层级的长度
        stack.push(0);

        int result=0;
        String[] strings=input.split("\n");
        for (String str:strings) {
            int level=str.lastIndexOf("\t")+1; //先将层级计算出来
            while(level+1<stack.size())stack.pop(); //如果stack中的size大于这个层级+1，就抛出去
            int len=str.substring(level).length(); //计算当前这个字符串的长度，除了”\t“

            if(str.contains("."))result=Math.max(result,stack.peek()+len); //是否到文件了，到了就计算路径总长度
            else stack.push(stack.peek()+len+1); //否则还是文件夹，将当前长度加上前面路径的长度，在加上文件夹之间的”/“
        }
        return result;
    }
}
