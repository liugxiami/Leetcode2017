package com.ccsi.leetcode4;

import java.util.*;

public class LC464CanIWin {
    public static boolean canIWin(int maxChoosableInteger,int desiredTotal){
        if(desiredTotal<=0)return true;
        if((maxChoosableInteger+1)*maxChoosableInteger/2<desiredTotal)return false;
        char[] state=new char[maxChoosableInteger]; //记录访问过的状态
        for (int i = 0; i < state.length; i++) { //初始化起始状态。
            state[i]='0';
        }
        return dfs(desiredTotal,state,new HashMap<>());
    }
    private static boolean dfs(int total,char[] state,HashMap<String,Boolean> visited){
        String str=new String(state); //脑补一下访问过的数的状态，访问过的相应位为1，未访问的是0
        if(visited.containsKey(str))return visited.get(str); //有可能重复访问，用一个map可以加速。
        for (int i = 0; i < state.length; i++) { //第一个人可以取任意一个数，
            if(state[i]=='0'){
                state[i]='1';
                //有两种情况能赢，一是加上当前这个数>=total了，而是第二个人输了，那自己自然就赢了。
                if(total<=i+1||!dfs(total-(i+1),state,visited)){
                    visited.put(str,true);
                    state[i]='0';
                    return true;
                }

                state[i]='0';
            }
        }
        visited.put(str,false); //如果试过了所有可能都不能返回true，那么就只能输了。
        return false;
    }
}
