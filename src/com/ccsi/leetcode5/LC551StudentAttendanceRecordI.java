package com.ccsi.leetcode5;

import java.util.*;

public class LC551StudentAttendanceRecordI {
    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }
    //if else的完美运用，关键点就是两个连续的L,一开始以为就是累加L.
    public static boolean checkRecord(String s){
        if(s==null||s.length()<2)return true;
        int a=0,l=0;
        char[] chars=s.toCharArray();
        for(char c:chars){
            if(c=='A')a++;
            if(c=='L')l++;
            else l=0;
            if(a>1||l>2)return false;
        }
        return true;
    }
}
