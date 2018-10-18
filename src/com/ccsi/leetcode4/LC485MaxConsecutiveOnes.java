package com.ccsi.leetcode4;

public class LC485MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums={0,0,1,1,0,1,1,1,0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int max=0;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if((i==0&&nums[i]==1)||(i>0&&nums[i-1]==0&&nums[i]==1)){
                count=1;
            }else if(i>0&&nums[i-1]==1&&nums[i]==1){
                count++;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
