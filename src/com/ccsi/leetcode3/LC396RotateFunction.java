package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/5/3.
 */
public class LC396RotateFunction {
    public static void main(String[] args) {
        int[] A={4,3,2,6};
        System.out.println(maxRotateFunction1(A));
    }
    //method1,将新数组B的index先算出来，newIndex=(oldIndex+k)%len;然后再将新数组的f算出来。
    //O(N^2)
    public static int maxRotateFunction(int[] A){
        if(A==null||A.length==0)return 0;
        int max=Integer.MIN_VALUE;
        int len=A.length;
        for (int k = 0; k < len; k++) {
            int sum=0;
            for (int oldIndex = 0; oldIndex < len; oldIndex++) {
                int newIndex=(oldIndex+k)%len;
                sum+=A[oldIndex]*newIndex;
            }
            max=Math.max(max,sum);
        }
        return max;
    }
    //找规律，可以做到O[N]的算法复杂度。
    /*
    *因为都是向右循环位移，那么除了当前数组的最后一个位置，全部都多了一个，而最后一个少了n-1个
    * （从n-1的系数变成0）。那么我们改变下，假设现在方程值是f，A的所有值的和是sa那么一次向右
    * 循环位移可以认为 1
    *   1、首先所有值都加一个自身，也就是和加上sa
    *   2、扣除1中多加的最后一个，以及原来就应该减掉的n个了，减掉A[n-i]*n就好
     */
    public static int maxRotateFunction1(int[] A){
        if(A==null||A.length==0)return 0;
        int len=A.length;

        int f0=0; //function(0)的值
        int aSum=0; //数组所有元素之和。
        for (int i = 0; i < len; i++) {
            f0+=A[i]*i;
            aSum+=A[i];
        }

        int fi=f0;
        int max=f0;
        for (int i = 1; i < len; i++) { //f(0)已经算出来了，从f(1)开始
            fi+=aSum; //相当于整个数组都向右移动了一位，也就是比上一次多了整个数组的总和，但最后一位归0了
            fi-=A[len-i]*len; //因为最后那个元素由*len变成*0了，所以要减去，但在上面上浮时也同时加上了一位
            //所以相当于*len了。
            max=Math.max(max,fi); //没走一位都要比较并记录当前的最大值。
        }
        return max;
    }
}
