package com.ccsi.leetcode4;

public class LC457CircularArrayLoop {
    public static void main(String[] args) {
        int[] nums={-1, 2};
        System.out.println(circularArrayLoop(nums));
    }
    //快慢指针，先找到环
    public static boolean circularArrayLoop(int[] nums){
        if(nums==null||nums.length<2)return false;
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i]==0)continue; //可以加快，避免重复计算

            int slow=i,fast=getIndex(i,nums); //申明快慢两指针，慢指针一次走一步，快指针走两步
            while(nums[i]*nums[slow]>0&&nums[i]*nums[fast]>0){  //用一个循环来找环，同时保证forward或backward
                if(slow==fast){//如果碰到慢指针很快指针相同，那么找到了一个环
                    if(slow==getIndex(slow,nums))break; //如果是单元素环，继续找
                    return true; //否则就是找到了
                }
                slow=getIndex(slow,nums);
                fast=getIndex(getIndex(fast,nums),nums);
            }
            //没有找到，将路径上的元素设为0
            int curr=i;
            int value=nums[i];
            while (value*nums[curr]>0){
                nums[curr]=0;
                curr=getIndex(curr,nums);
            }

        }
        return false; //如果整个数组都走完了还没找到合适的环，返回false。
    }
    private static int getIndex(int curr,int[] nums){
        int len=nums.length;
        int next=(curr+nums[curr])%len;
        if(next<0)next+=len;
        return next;
    }
}
