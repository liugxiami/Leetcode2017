package com.ccsi.leetcode4;

import java.util.*;

public class LC455AssignCookies {
    public static void main(String[] args) {
        int[] g={1,2};
        int[] s={1,2,3};
        System.out.println(findContentChildren(g,s));
    }
    public static int findContentChildren(int[] g,int[] s){
        if(g==null||g.length==0||s==null||s.length==0)return 0;
        int gLen=g.length;
        int sLen=s.length;
        int result=0;

        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i<gLen&&j<sLen){
            if(s[j]>=g[i]){
                result++;
                i++;
                j++;
            }else j++;
        }
        return result;
    }
}
