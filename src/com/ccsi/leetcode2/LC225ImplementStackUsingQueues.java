package com.ccsi.leetcode2;

import java.util.LinkedList;
import java.util.*;

/**
 * Created by gxliu on 2017/12/18.
 */
public class LC225ImplementStackUsingQueues {
    private Queue<Integer> queue;
    public LC225ImplementStackUsingQueues(){
        this.queue=new LinkedList<>();
    }
    //push O（N）
    public void push(int x){
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) { //注意，这边是进行n-1次循环，不是n，那的话就恢复原状了。
            queue.offer(queue.poll());
        }
    }
    //pop O(1)
    public void pop(){
        queue.poll();
    }
    //top O（1）
    public int top(){
        if(!queue.isEmpty()) return queue.peek();
        else return -1;
    }
    //O（1）
    public boolean empty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        LC225ImplementStackUsingQueues stack=new LC225ImplementStackUsingQueues();
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();
        stack.push(6);
        stack.pop();
        stack.pop();

        System.out.println(stack.top());
        System.out.println(stack.empty());
    }
}
