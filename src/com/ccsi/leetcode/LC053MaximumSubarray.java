package com.ccsi.leetcode;

/**
 * Created by gxliu on 2017/9/27.
 */
public class LC053MaximumSubarray {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(nums));
    }
    //算法复杂度是O[n]。 贪心算法，需要两个局部变量，一个记录当前sum，一个记录最大值。
    //对数组进行迭代，每次将当前元素加进sum，如果sum<0，那么从新开始，也就是当前这个元素必定是小于0的，那么可以从新开始。
    public static int maxSubArray(int[] nums){
        if(nums==null||nums.length==0)return Integer.MIN_VALUE;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }
    //divide & conquer
    public static int maxSubArray1(int[] nums){
        if(nums==null||nums.length==0)return Integer.MIN_VALUE;
        int max=helper(nums,0,nums.length-1);
        return max;
    }
    private static int helper(int[] nums,int start,int end){
        if(start>end)return Integer.MIN_VALUE;

        if(start==end)return nums[start];

        int mid=start+(end-start)/2;
        int leftMax=helper(nums,start,mid-1);
        int rightMax=helper(nums,mid+1,end);

        int sum=0,mLeftMax=0;
        for (int i = mid-1; i >=start ; i--) {
            sum+=nums[i];
            if(mLeftMax<sum){
                mLeftMax=sum;
            }
        }
        sum=0;
        int mRightMax=0;
        for (int i = mid+1; i <= end; i++) {
            sum+=nums[i];
            if(mRightMax<sum){
                mRightMax=sum;
            }
        }

        int max=Integer.MIN_VALUE;
        max=Math.max(max,leftMax);
        max=Math.max(max,rightMax);
        max=Math.max(max,mLeftMax+nums[mid]+mRightMax);
        return max;
    }
}
