package com.ccsi.leetcode4;

import java.util.*;

public class LC488ZumaGame {
    public static void main(String[] args) {
        String board="RRGGWYYWWGGR";
        String hand="YRG";
        System.out.println(findMinStep(board,hand));
    }
    public static int findMinStep(String board,String hand){
        int[] map=new int[26];//mini map
        for(char color:hand.toCharArray()){
            map[color-'A']++;
        }
        return DFS(board,map);
    }
    //return the min # of balls needed in hand to clear the board
    private static int DFS(String board,int[] map){
        board=update(board);
        if(board.isEmpty())return 0;

        int count=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        while(start<board.length()){
            while(end<board.length()&&board.charAt(end)==board.charAt(start))end++;
            //board[start] to board[end-1] have same color
            char color=board.charAt(start); //current color
            //# of balls needed to clear board[start] to board[end-1]
            int need=3-(end-start);
            //Have sufficient balls in hand
            if(map[color-'A']>=need){
                //remove board[start] to board[end-1] and update the board
                String newBoard=board.substring(0,start)+board.substring(end);
                //find the solution on new board with updated hand
                map[color-'A']-=need;
                int temp=DFS(newBoard,map);
                if(temp>=0)count=Math.min(count,temp+need);
                map[color-'A']+=need;
            }
            start=end;
        }
        return count==Integer.MAX_VALUE?-1:count;
    }
    //update the board by removing all consecutive 3+ balls
    private static String update(String board){
        int start=0;
        while(start<board.length()){
            int end=start;
            while(end<board.length()&&board.charAt(end)==board.charAt(start))end++;
            if(end-start>=3){
                board=board.substring(0,start)+board.substring(end);
                start=0; //start要归0，否则如"RRGGWYYWWGGR"会出错，因为开始去除Y之后，start还处在4的位置，那么之后去除W，此时
                //start还处在4位置，这是GGGG就不能自动消除了。
            }
            else start++;
        }
        return board;
    }
}
