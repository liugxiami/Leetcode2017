package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2017/12/17.
 */
public class LC223RectangleArea {
    public static void main(String[] args) {
        int ares=computeArea(-3,0,3,4,0,-1,9,2);
        System.out.println(ares);
    }
    public static int computeArea(int A,int B,int C,int D,int E,int F,int G,int H){
        int area1=calculateArea(A,B,C,D); //第一个长方形的面积
        int area2=calculateArea(E,F,G,H); //第二个长方形的面积

        if(A>G||E>C||B>H||F>D)return area1+area2; //如果没有overlap的情况的话，就是两长方形面积总和。

        int left=Math.max(A,E);
        int bottom=Math.max(B,F);
        int right=Math.min(C,G);
        int top=Math.min(D,H);
        int overlap=calculateArea(left,bottom,right,top); //两个长方形的overlap的面积。如果有重复的话，这部分被重复用了一次。

        return area1+area2-overlap;
    }
    private static int calculateArea(int left,int bottom,int right,int top){
        return (right-left)*(top-bottom);
    }
}
