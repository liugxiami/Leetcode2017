package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/7/20.
 */
public class LC011ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height={3,4,3,1,4,5};
        System.out.println(maxArea1(height));
    }
    public static int maxArea(int[] height){
        if(height==null||height.length<=1)return 0;
        int max=0;
        int len=height.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int currArea=Math.min(height[i],height[j])*(j-i);
                max=Math.max(max,currArea);
            }
        }
        return max;
    }

    public static int maxArea1(int[] height){
        if(height==null||height.length<=1)return 0;
        int max=0;
        int left=0,right=height.length-1;
        while(left<right){
            max=Math.max(max,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right])left++;
            else right--;
        }
        return max;
    }
    //对上面解法进行优化
    public static int maxArea2(int[] height){
        if(height==null||height.length<=1)return 0;
        int max=0;
        int left=0,right=height.length-1;
        while(left<right){
            max=Math.max(max,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                int index=left;
                while(left<right&&height[left]<=height[index]){
                    left++;
                }
            }else{
                int index=right;
                while(right>left&&height[right]<=height[index]){
                    right--;
                }
            }
        }
        return max;
    }
}
