package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/14.
 */
public class LC042TrappingRainWater {
    public static int trap(int[] height){
        if(height==null||height.length<=2)return 0;
        int len=height.length;
        int[] array=new int[len];

        for (int i = 0; i < len; i++) {
            if(i==0)array[i]=height[i];
            else array[i]=(height[i]>array[i-1]?height[i]:array[i-1]);
        }

        int[] reArray=new int[len];
        for (int i = len-1; i >=0 ; i--) {
            if(i==len-1)reArray[i]=height[i];
            else reArray[i]=(height[i]>reArray[i+1]?height[i]:reArray[i+1]);
        }

        int sum=0;
        for (int i = 0; i < len; i++) {
            array[i]=Math.min(array[i],reArray[i]);
            sum+=array[i]-height[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
