package com.ccsi.leetcode4;

public class LC492ConstructTheRectangle {
    public static void main(String[] args) {
        int[] result=constructRectangle1(49);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    public static int[] constructRectangle1(int area){
        int width=(int)Math.sqrt(area);
        while(area%width!=0)width--;
        int length=area/width;
        return new int[]{width,length};
    }
}
