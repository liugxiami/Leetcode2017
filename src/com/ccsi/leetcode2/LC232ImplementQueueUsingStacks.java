package com.ccsi.leetcode2;

import java.util.*;

/**
 * Created by gxliu on 2017/12/20.
 */
public class LC232ImplementQueueUsingStacks {
    private Stack<Integer> stack;
    private Stack<Integer> reverseStack;
    public LC232ImplementQueueUsingStacks(){
        this.stack=new Stack<>();
        this.reverseStack=new Stack<>();
    }
    public void push(int x){
        stack.clear();
        while(!reverseStack.isEmpty()){
            stack.push(reverseStack.pop());
        }
        stack.push(x);
        reverseStack.clear();
        while(!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }
    }
    public int pop(){
        if(!reverseStack.isEmpty())return reverseStack.pop();
        else return -1;
    }
    public int peek(){
        if(!reverseStack.isEmpty())return reverseStack.peek();
        else return -1;
    }
    public boolean empty(){
        return reverseStack.isEmpty();
    }

    public static void main(String[] args) {
        LC232ImplementQueueUsingStacks myQueue=new LC232ImplementQueueUsingStacks();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        while(!myQueue.empty()){
            System.out.println(myQueue.pop());
        }
    }
}
