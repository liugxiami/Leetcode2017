package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/25.
 */
public class LC155MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public LC155MinStack(){
        this.stack=new Stack<>();
        this.minStack=new Stack<>();
    }

    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty()||x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop(){
        if(stack.isEmpty())return;

        int temp=stack.pop();
        if(!minStack.isEmpty()&&temp==minStack.peek()){
            minStack.pop();
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args) {
        LC155MinStack minStack=new LC155MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println( minStack.top());
        System.out.println(minStack.getMin());
    }
}
