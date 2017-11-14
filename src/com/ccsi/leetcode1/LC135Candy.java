package com.ccsi.leetcode1;

import java.util.Arrays;

/**
 * Created by gxliu on 2017/11/13.
 */
public class LC135Candy {
    public static void main(String[] args) {
        int[] ratings={3,2,5,7,9,8,3,4};
        System.out.println(candy1(ratings));
    }
    //用了两个数组。
    public static int candy(int[] ratings){
        if(ratings==null||ratings.length==0)return 0;
        int len=ratings.length;
        int[] left=new int[len];
        int[] right=new int[len];
        int amount=0;

        for (int i = 0; i < len; i++) {
            left[i]=1;
            right[i]=1;
        }

        for (int i = 1; i < len; i++) {
            if(ratings[i]>ratings[i-1])left[i]=left[i-1]+1;
        }

        right[len-1]=left[len-1];

        for (int i = len-2; i >=0; i--) {
            if(ratings[i]>ratings[i+1])right[i]=right[i+1]+1;
        }

        for (int i = 0; i < len; i++) {
            amount+=Math.max(left[i],right[i]);
        }

        return amount;
    }
    //缩减为一个数组
    public static int candy1(int[] ratings){
        if(ratings==null||ratings.length==0)return 0;
        int len=ratings.length;
        int result=0;
        int[] array=new int[len];
        Arrays.fill(array,1);
        for (int i = 1; i < len; i++) {
            if(ratings[i]>ratings[i-1])array[i]=array[i-1]+1;
        }
        for (int i= len-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])array[i]=Math.max(array[i],array[i+1]+1);
        }
        for (int i = 0; i < len; i++) {
            result+=array[i];
        }
        return result;
    }
}
