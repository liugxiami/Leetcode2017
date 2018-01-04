package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/3.
 */
public class LC275HIndexII {
    public static void main(String[] args) {
        int[] citations={2,3,4,4,5,6};
        System.out.println(hIndex1(citations));
    }
    //二分查找。
    public static int hIndex(int[] citations){
        if(citations==null||citations.length==0)return 0;
        int len=citations.length;
        int start=0;
        int end=len-1;
        int h=0;
        while(start<end){
            int mid=(end-start)/2+start;
            if(len-mid<=citations[mid]){
                h=len-mid;
                end=mid-1;
            }else start=mid+1;
        }
        return h;
    }
    public static int hIndex1(int[] citations){
        if(citations==null||citations.length==0)return 0;
        int len=citations.length;
        int start=0;
        int end=len-1;
        while(start<end){
            int mid=(end-start)/2+start;
            if(len-mid==citations[mid])return len-mid;
            else if(len-mid<citations[mid]){
                end=mid-1;
            }else start=mid+1;
        }
        return len-start;
    }
}
