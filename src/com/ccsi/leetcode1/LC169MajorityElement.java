package com.ccsi.leetcode1;

import java.util.*;

/**
 * Created by gxliu on 2017/11/29.
 */
public class LC169MajorityElement {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,2,2,2,3,3,3,4};
        System.out.println(majorityElement2(nums));
    }
    //method1,用一个map来记录，key为元素值，value为出现次数，最后迭代一遍map找出出现次数最多的，这不是最快的。
    public static int majorityElement(int[] nums){
        if(nums==null||nums.length==0)return -1;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        int max=0;
        int result=Integer.MAX_VALUE;
        for(Integer num:map.keySet()){
            if(map.get(num)>max){
                max=map.get(num);
                result=num;
            }
        }
        return result;
    }
    //method2：根据定义"The majority element is the element that appears more than ⌊ n/2 ⌋ times."，
    public static int majorityElement1(int[] nums){
        if(nums==null||nums.length==0)return -1;
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if(stack.isEmpty()||nums[i]==stack.peek()){
                stack.push(nums[i]);
            }else{
                stack.pop();
            }
        }
        return stack.pop();
    }
    //method3,对上面算法的优化
    //用一个变量major记录主元素，以及count记录这个元素出现的次数，如果后面的元素和它相同就+1，有一个元素和他不相同就-1，
    //当count等于0时重新记录新的元素。  O（1）
    public static int majorityElement2(int[] nums){
        int major=nums[0];// 用于记录主元素，假设第一个是主元素
        int count=1;// 用于抵消数的个数

        for (int i = 1; i < nums.length; i++) {// 从第二个元素开始到最后一个元素
            if(nums[i]==major)count++;// 如果两个数相同就不能抵消,用于抵消的数据加1
            else{
                if(count>0)count--;// 如果不相同，并且有可以抵消的数,进行数据抵消
                else {// 如果不相同，并且没有可以抵消的数
                    major=nums[i];// 替换新的主元素。
                    count=1;
                }
            }
        }
        return major;
    }
}
