package com.ccsi.leetcode5;

import java.util.*;

public class LC528RandomPickWithWeight {
    private int[] sumW;
    private Random random;
    private int sum;
    private int len;
    public LC528RandomPickWithWeight(int[] w){
        random=new Random();
        sum=0;
        len=w.length;
        sumW=new int[len];
        for (int i = 0; i < w.length; i++) {
            sum+=w[i];
            sumW[i]=sum;
        }
    }

    public int pickIndex(){
        int temp=random.nextInt(sum)+1; //The nextInt(int n) method is used to get a pseudorandom,
        // uniformly distributed int value between 0 (inclusive) and the specified value (exclusive)
        int left=0,right=len-1;
        while(left<right){
            int mid=(right-left)/2+left;
            if(sumW[mid]==temp)return mid;
            else if(sumW[mid]<temp)left=mid+1;
            else right=mid; //为什么不是mid-1？
        }
        return right;
    }
    public static void main(String[] args) {
        int[] w={10,30,60};
        LC528RandomPickWithWeight r=new LC528RandomPickWithWeight(w);
        int count1=0;
        int count2=0;
        int count0=0;
        for (int i = 0; i < 10000; i++) {
            int index=r.pickIndex();
            if(index==1)count1++;
            if(index==2)count2++;
            if(index==0)count0++;
        }
        System.out.println(count0);
        System.out.println(count1);
        System.out.println(count2);
    }
}
