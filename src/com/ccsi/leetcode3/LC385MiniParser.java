package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/17.
 */

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class LC385MiniParser {
    //method1 recursion,不太好理解。
    public static NestedInteger deserialize(String s){
        if(s==null)return new NestedInteger();
        if(s.charAt(0)!='[')return new NestedInteger(Integer.parseInt(s));
        if(s.length()<=2)return new NestedInteger();

        NestedInteger res=null;
        int start=1;
        int level=0;
        for (int i = 1; i < s.length(); i++) {
            if(level==0&&s.charAt(i)==','||s.charAt(i)==']'){
                res.add(deserialize(s.substring(start,i)));
                start=i+1;
            }else if(s.charAt(i)=='[')level++;
            else if(s.charAt(i)==']')level--;
        }
        return res;
    }
    //method2 还是用stack来做好
    public static NestedInteger deserialize1(String s){
        if(s==null||s.length()==0)return new NestedInteger();
        if(s.charAt(0)!='[')return new NestedInteger(Integer.valueOf(s));

        Stack<NestedInteger> stack=new Stack<>();
        NestedInteger res=new NestedInteger();
        stack.push(res);
        int start=1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)=='['){
                NestedInteger temp=new NestedInteger();//没碰到一个‘[’,都要增加一个NestedInteger
                stack.peek().add(temp); //这个应该是多余的了
                stack.push(temp); //并放入stack
                start=i+1; //记得更新start
            }else if(s.charAt(i)==','||s.charAt(i)==']'){ //当前这个数结束了
                if(i>start){
                    int val=Integer.valueOf(s.substring(start,i)); //获得这个数
                    stack.peek().add(new NestedInteger(val)); //把这个新的nestedInteger放进stack最上面
                }
                start=i+1; //更新start
                if(s.charAt(i)==']'){ //确实是结束了，就要将最上面的元素放进倒数第二个元素里面去，如果存在的话。
                    if(stack.size()>1){
                        NestedInteger temp=stack.pop();
                        stack.peek().add(temp);
                    }
                }
            }
        }
        return res;
    }
}
