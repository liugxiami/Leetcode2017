package com.ccsi.leetcode2;

/**
 * Created by gxliu on 2018/1/3.
 */
public class LC278FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(100));
    }
    //二分查找
    public static int firstBadVersion(int n){
        if(n<1)return 0;
        int start=1;
        int end=n;
        int badVersion=0;
        while(start<=end){
            int mid=(end-start)/2+start;
            if(isBadVersion(mid)){
                badVersion=mid;
                System.out.println(badVersion);
                end=mid-1;
            }else start=mid+1;
        }
        return badVersion;
    }
    //还是二分查找，更通用的写法,循环结束之后，总是剩下两个相邻指针，在分别判断一下。
    public static int firstBadVersion1(int n){
        if(n<1)return 0;
        int start=1;
        int end=n;
        while(start+1<end){
            int mid=(end-start)/2+start;
            if(isBadVersion(mid)){
                System.out.println(mid);
                end=mid;
            }else start=mid;
        }

        if(isBadVersion(start))return start;
        else return end;
    }
    public static boolean isBadVersion(int version){
        if(version>=5)return true;
        else return false;
    }
}
