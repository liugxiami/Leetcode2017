package com.ccsi.leetcode5;

public class LC540SingleElementInaSortedArray {
    public static void main(String[] args) {
        int[] nums={7,8,8,9,9,10,10};
        System.out.println(sigleNonDuplicate(nums));
    }
    public static int sigleNonDuplicate(int[] nums){
        if(nums.length==1)return nums[0];
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid=(end-start)/2+start;
            if(nums[mid]==nums[mid-1]){ //如果和前一个数相同
                if((mid-start+1)%2==0){ //mid前面有偶数个，后面半段找
                    start=mid+1;
                }else{
                    end=mid;
                }
            }else{ //和前一个数不相同
                if((mid-start)%2==0){ //start到mid-1有偶数个的话，后半段找
                    start=mid;
                }else{ //否则前半段找
                    end=mid-1;
                }
            }
        }
        return nums[end];
    }
}
