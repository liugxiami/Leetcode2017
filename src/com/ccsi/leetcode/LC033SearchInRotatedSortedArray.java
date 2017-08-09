package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/8/7.
 */
public class LC033SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array={4,5,6,7,0,1,2,3};
        System.out.println(search(array,8));
    }
    public static int search(int[] array,int target){
        if(array==null||array.length==0)return -1;
        int len=array.length;
        int left=0,right=len-1;
        while (left<=right){     //注意是<=
            int mid=left+(right-left)/2;
            if(array[mid]==target)return mid;

            if(array[mid]>=array[left]){  //左边是排好序的情况
                if(target>=array[left]&&target<array[mid]){ //如果target在左边，那么right=mid-1；
                    right=mid-1;
                }else{                                      //否则就在右边找
                    left=mid+1;
                }
            }else{                         //右边是排好序的情况
                if(target>array[mid]&&target<=array[right]){ //如果target是在右边，那么left=mid+1；
                    left=mid+1;
                }else{                                       //否则就在左边找。
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}
