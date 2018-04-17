package com.ccsi.leetcode3;

import java.util.*;

/**
 * Created by gxliu on 2018/4/16.
 */
public class LC384ShuffleAnArray {
    private int[] array=null;
    private Random random=null;
    public LC384ShuffleAnArray(int[] nums){
        this.array=nums;
        this.random=new Random();
    }

    public int[] reset(){
        return array;
    }

    public int[] shuffle(){
        if(array==null)return array;
        int[] a=(int[])array.clone();

        for (int i = 1; i < array.length; i++) {
            int ran=random.nextInt(i+1);
            swap(a,i,ran);
        }
        return a;
    }

    private void swap(int[] a,int p,int q){
        int temp=a[p];
        a[p]=a[q];
        a[q]=temp;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        LC384ShuffleAnArray shuffle=new LC384ShuffleAnArray(nums);
        int[] result=shuffle.shuffle();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(result[i]);
        }
        int[] res=shuffle.reset();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(res[i]);
        }
    }
}
