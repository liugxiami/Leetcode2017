package com.ccsi.leetcode;

import java.util.*;

/**
 * Created by gxliu on 2017/10/11.
 */
public class LC080RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,2,2,2,3};
        System.out.println(removeDuplicates1(nums));
    }
    public static int removeDuplicates(int[] nums){
        if(nums==null)return -1;
        if(nums.length<=2)return nums.length;
        Queue<Integer> queue=new LinkedList<>();
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(queue.isEmpty()){
                queue.offer(nums[i]);
            }else if(queue.peek()!=nums[i]){
                while(!queue.isEmpty())nums[index++]=queue.poll();
                queue.offer(nums[i]);
            }else{
                queue.offer(nums[i]);
                if(queue.size()>2)queue.poll();
            }
        }
        while(!queue.isEmpty())nums[index++]=queue.poll();
        return index;
    }
    public static int removeDuplicates1(int[] nums){
        if(nums==null)return -1;
        int len=nums.length;
        if(len<=2)return len;
        int index=0;   //需要一个新数组指针
        for(int num:nums){  //对原数组进行迭代
            if(index<2||num!=nums[index-2]){  //如果新数组的index还是小于2的情况下，直接赋值；如果当前原数组
                //的元素不等于（也可以是大于，如果这个数组是递增的话）新数组的倒数第二个元素，那么赋值，index++；如果
                //等于新数组的倒数第二个元素，那么略过，看下一个元素。这个写法和removeDuplicateI和相似。
                nums[index++]=num;
            }
        }
        return index;
    }
}
