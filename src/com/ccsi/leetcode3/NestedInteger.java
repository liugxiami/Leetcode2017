package com.ccsi.leetcode3;

import java.util.List;

/**
 * Created by gxliu on 2018/4/17.
 */
public class NestedInteger {
    // interface cannot have constructors.
    //Constructor initializes an empty nested list.
    public NestedInteger()
    {

    }
    // Constructor initializes a single integer.
    public NestedInteger(int value){

    }
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){
        return true;
    }
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){
        return 1;
    }
    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){

    }
    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){

    }
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    //Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){
        return null;
    }
}
