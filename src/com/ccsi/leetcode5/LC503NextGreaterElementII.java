package com.ccsi.leetcode5;

import java.util.*;

public class LC503NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums={1,2,3,2,1};
        int[] result=nextGreaterElements(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    // index 用一个stack
    //栈顶 1，2，3，4，5，6 栈底
    //从index 6往前看起，如果比当前数小或相等就抛出，否则该数的下一个大于自己的数就是当前栈顶的这个数了，
    //再将现在真正查看的index压人栈顶，可以想象，整个循环结束，会压人 6 5 4 3 2 1 一遍
    public static int[] nextGreaterElements(int[] nums){
        if(nums==null||nums.length==0)return new int[0];
        int len=nums.length;
        int[] result=new int[len];
        Stack<Integer> stack=new Stack<>(); //store index

        for (int i = len-1; i >=0 ; i--) {
            stack.push(i); //后进先出，出来的时候index从小到大
        }

        for (int i = len-1; i >=0; i--) {
            result[i]=-1; //initiate to -1;
            while(!stack.isEmpty()&&nums[stack.peek()]<=nums[i])stack.pop(); //如果当前数大于stack里面的index
            //对应的数，那么就pop出去
            if(!stack.isEmpty())result[i]=nums[stack.peek()]; //当前这个位置上的数后面一个大于自己的数就是stack顶的数了。
            stack.push(i); //将当前这个位置放回到栈顶。进行下一次循环，下次是往回走了一个
        }
        return result;
    }
}
