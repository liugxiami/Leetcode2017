package com.ccsi.leetcode4;

import java.util.*;

public class LC4544SumII {
    public static void main(String[] args) {
        int[] A={1,2};
        int[] B={-2,-1};
        int[] C={-1,2};
        int[] D={0,2};
        System.out.println(fourSumCount(A,B,C,D));
    }
    public static int fourSumCount(int[] A,int[] B,int[] C,int[] D){
        Map<Integer,Integer> map=new HashMap<>();
        for (int a:A) {
            for (int b:B) {
                int sum=a+b;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        int result=0;
        for(int c:C){
            for(int d:D){
                int sum=c+d;
                result+=map.getOrDefault(-sum,0);
            }
        }
        return result;
    }
}
