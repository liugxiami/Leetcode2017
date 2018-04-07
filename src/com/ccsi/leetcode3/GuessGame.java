package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/5.
 */
public class GuessGame {
    public int guess(int num){
        int n=10;
        if(n>num)return 1;
        else if(num==n)return 0;
        else return -1;
    }
}
