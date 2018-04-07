package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/4/5.
 */
public class LC374GuessNumberHigherOrLower extends GuessGame {
    public int guessNumber(int n){
        if(guess(n)==0)return n;
        int left=1;
        int right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            int temp=guess(mid);
            if(temp==0)return mid;
            else if(temp==1)left=mid+1;
            else right=mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        LC374GuessNumberHigherOrLower guess=new LC374GuessNumberHigherOrLower();
        System.out.println(guess.guessNumber(60));
    }
}
