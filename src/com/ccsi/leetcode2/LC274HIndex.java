package com.ccsi.leetcode2;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gxliu on 2018/1/2.
 */
public class LC274HIndex {
    public static void main(String[] args) {
        int[] citations={0};
        System.out.println(hIndex1(citations));
    }
    //nlgn
    public static int hIndex(int[] citations){
        if(citations==null||citations.length==0)return 0;
        int len=citations.length;
        //先对数组进行逆序排列，因为Arrays.sort()并无此功能，所以先将其乘以-1，升序排列，再乘以-1.
        for (int i = 0; i < len; i++) {
            citations[i]*=-1;
        }
        Arrays.sort(citations);
        for (int i = 0; i < len; i++) {
            citations[i]*=-1;
        }

        int min=1;
        int max=1;
        //关键步骤，h-index = max {min(citations[i],i)};贪心算法
        for (int i = 0; i < len; i++) {
            min=Math.min(i+1,citations[i]); //发表的文章实际是以1-base的，所以是i+1；
            max=Math.max(max,min);
        }
        return max;
    }
    //method2 partition
    public static int hIndex1(int[] citations){
        if(citations==null||citations.length==0)return 0;
        int len=citations.length;

        int start=0;
        int end=len-1;
        int h=0;

        while(start<=end){
            int curr=partion(citations,start,end);//curr is index
            if(curr+1<=citations[curr]){
                h=curr+1;
                start=curr+1;
            }else{
                end=curr-1;
            }
        }
        return h;
    }
    //这个partion与正常的快排不一样的地方是：是大于等于pivot的在前面，小于pivot的在后面。
    private static int partion(int[] citations,int start,int end){
        if(start==end)return start;
        int ran=new Random().nextInt(end-start)+start;

        swap(citations,start,ran);
        int pivot=citations[start];

//        int left=start;
//        int right=end+1;
//        while(true){
//            while(++left<=end&&citations[left]>=pivot);
//            while(--right>=start&&citations[right]<pivot);
//            if(left>right)break;
//            swap(citations,left,right);
//        }
//        swap(citations,start,right);
//        return right;

        int head=start+1;
        for (int i = start+1; i <=end ; i++) {
            if(citations[i]>=pivot){
                swap(citations,head++,i);
            }
        }
        swap(citations,start,head-1);
        return head-1;
    }
    private static void swap(int[] citations,int p,int q){
        if(p==q)return;
        int temp=citations[p];
        citations[p]=citations[q];
        citations[q]=temp;
    }
}
