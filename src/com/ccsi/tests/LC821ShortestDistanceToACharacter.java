package com.ccsi.tests;

import java.util.*;

/**
 * Created by gxliu on 2018/4/22.
 */
public class LC821ShortestDistanceToACharacter {
    public static void main(String[] args) {
        String S="loveleetcode";
        char c='e';
        int[] result=shortestToChar1(S,c);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    //method1 TreeSet
    public static int[] shortestToChar(String S,char C){
        if(S==null||S.length()==0)return null;
        int len=S.length();
        int[] result=new int[len];
        Arrays.fill(result,len);
        char[] chars=S.toCharArray();
        TreeSet<Integer> set=new TreeSet<>();
        for (int i = 0; i < len; i++) {
            if(C==chars[i])set.add(i);
        }

        for (int i = 0; i < len; i++) {
            char curr=chars[i];
            if(curr==C)result[i]=0;
            else {
                Integer right=set.ceiling(i);
                Integer left=set.floor(i);
                if(right!=null){
                    result[i]=right-i;
                }
                if(left!=null){
                    result[i]=Math.min(result[i],i-left);
                }
            }
        }
        return result;
    }
    //和蓄水池的体类似，但需要记录第一次和最后一次出现c的位置，用两个数组来辅助
    public static int[] shortestToChar1(String S,char C){
        if(S==null||S.length()==0)return null;
        int len=S.length();
        int[] result=new int[len];

        int[] left=new int[len];
        int[] right=new int[len];
        char[] chars=S.toCharArray();

        int count=0;
        int leftIndex=len;
        for (int i = 0; i < len; i++) {
            if(C!=chars[i]){
                count++;
            }else {
                count=0;
                leftIndex=Math.min(leftIndex,i);
            }

            left[i]=count;
        }
        count=0;
        int rightIndex=-1;
        for (int i = len-1; i >=0 ; i--) {
            if(C!=chars[i]){
                count++;
            }else {
                count=0;
                rightIndex=Math.max(rightIndex,i);
            }

            right[i]=count;
        }

        for (int i = 0; i < len; i++) {
            if(i<leftIndex){
                result[i]=right[i];
            }else if(i>rightIndex){
                result[i]=left[i];
            }else{
                result[i]=Math.min(left[i],right[i]);
            }
        }
        return result;
    }
}
