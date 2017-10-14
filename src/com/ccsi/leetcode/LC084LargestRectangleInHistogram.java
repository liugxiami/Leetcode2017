package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/13.
 */
public class LC084LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights={1,2,2};
        System.out.println(largestRectangleArea1(heights));
    }
    //brute-force，超时
    //思路：从开始往后迭代，如果是递增的，则一直往前走，碰到最大值，暂停，从当前的index往前算最大面积，
    //利用一个count来表示横坐标上的值，每往前走一步+1，同时找到当前的最小heights，与count的乘积就是面积，与max比较记录最大
    //面积，一直到index==0；
    //算完之后继续外层循环找下一个山头，同上找最大值，一直到最后一个数。
    //这个算法超时。
    public static int largestRectangleArea(int[] heights){
        if(heights==null||heights.length==0)return 0;
        int len=heights.length;

        int max=heights[0];
        for (int i = 1; i < len; i++) {
            if(heights[i]<heights[i-1]||i==len-1){
                int index=i==len-1?i:i-1;
                int count=0;
                int min=heights[index];
                for(int j=index;j>=0;j--){
                    count++;
                    min=Math.min(min,heights[j]);
                    max=Math.max(max,min*count);
                }
            }
        }
        return max;
    }
    //method2 借用一个stack，思路类似上面，stack用来存储非递减的index，碰到的元素比stack里的大于等于就进栈，否则就出栈，
    //并计算面积，先得到宽带为i-stack.peek（）-1；
    public static int largestRectangleArea1(int[] heights){
        if(heights==null||heights.length==0)return 0;

        int len=heights.length;
        int max=0;
        Stack<Integer> stack=new Stack<>();

        for (int i = 0; i <= len; i++) { //为了保证最后一个元素也能进栈，然后出栈比较，就都给一个结尾元素0，否则最后的两位
            //是递增的情况的话，就只进栈而没法比较了，可能会错失结果。
            int curr=i==len?0:heights[i];
            while(!stack.isEmpty()&&curr<=heights[stack.peek()]){
                int currIndex=stack.pop();
                int height=heights[currIndex];
                int wide=stack.isEmpty()?i:i-stack.peek()-1;//如果stack空了，那么就是整长了，也没法peek了。必须是stack.peek（）-1；
                max=Math.max(max,wide*height);
            }
            stack.push(i);
        }
        return max;
    }
}
