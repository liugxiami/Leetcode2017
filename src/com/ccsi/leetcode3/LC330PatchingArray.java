package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/3/5.
 */
public class LC330PatchingArray {
    //greedy
    public static void main(String[] args) {
        int[] nums={1, 2, 4, 11, 30};
        System.out.println(minPatches(nums,50));
    }
    public static int minPatches(int[] nums,int n){
        int patchCount=0,i=0;
        long miss=1; //必须是long类型，否则不能通过测试。
        while(miss<=n){
            if(i<nums.length&&nums[i]<=miss){
                miss+=nums[i++];
            }else{
                //System.out.println(miss);
                miss+=miss;
                patchCount++;
            }
        }
        return patchCount;
    }
}
