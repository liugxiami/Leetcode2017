package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/3/14.
 */
public class LC341FlattenNestedListIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;
    public LC341FlattenNestedListIterator(List<NestedInteger> nestedList) {
        if(nestedList==null)return;

        this.stack=new Stack<>();
        for (int i = nestedList.size()-1; i >=0 ; i--) {
            this.stack.push(nestedList.get(i));
        }
    }
    @Override
    public Integer next(){
        if(!hasNext())return null;
        NestedInteger curr=stack.pop();
        return curr.getInteger();

    }
    @Override
    public boolean hasNext(){
        while(!stack.isEmpty()){
            NestedInteger top=stack.peek();
            if(top.isInteger()){
                return true;
            }else{
                stack.pop();
                List<NestedInteger> curr=top.getList();
                for (int i = curr.size()-1; i >=0 ; i--) {
                    stack.push(curr.get(i));
                }
            }
        }
        return false;
    }
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public interface NestedInteger {

         // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();
         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
    }

}
