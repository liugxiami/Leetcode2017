package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/3/5.
 */
public class LC331VeriyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        String preorder="9,#,#,1";
        System.out.println(isValidSerialization(preorder));
    }
    //统计树的出度（out-degree）和入度（in-degree）
    public static boolean isValidSerialization(String preorder){
        if(preorder==null||preorder.length()==0)return false;
        String[] arrays=preorder.split(",");
        int len=arrays.length;
        int diff=1;
        for (int i = 0; i < len; i++) {
            diff-=1;
            if(diff<0)return false;
            if(!arrays[i].equals("#"))diff+=2;
        }
        return diff==0;
    }
}
