package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/11/24.
 */
public class LC152MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums={2,3,-2,4,-2,4};
        System.out.println(maxProduct1(nums));
    }
    //DP
    //对于这道题，稍微复杂了一点，子数组乘积最大值的可能性为：累乘的最大值碰到了一个正数；或者，累乘的最小值（负数），碰到了
    // 一个负数。所以每次要保存累乘的最大（正数）和最小值（负数）。同时还有一个选择起点的逻辑，如果之前的最大和最小值同当前
    // 元素相乘之后，没有当前元素大（或小）那么当前元素就可作为新的起点。例如，前一个元素为0的情况，{1,0,9,2}，到9的时候9
    // 应该作为一个最大值，也就是新的起点，{1,0,-9,-2}也是同样道理，-9比当前最小值还小，所以更新为当前最小值。这种方法只
    // 需要遍历一次数组即可，算法时间复杂度为O(n)。

    //状态方程：
    //max_product[i] = Math.max(max_product[i-1] * nums[i], min_product[i-1] * nums[i], nums[i])
    //min_product[i] = Math.min(max_product[i-1] * nums[i], min_product[i-1] * nums[i], nums[i])
    //method1
    public static int maxProduct(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int[] max=new int[len];
        int[] min=new int[len];

        int result=max[0];
        max[0]=min[0]=nums[0];
        for (int i = 1; i < len; i++) {
            max[i]=Math.max(nums[i],Math.max(max[i-1]*nums[i],min[i-1]*nums[i]));
            min[i]=Math.min(nums[i],Math.min(max[i-1]*nums[i],min[i-1]*nums[i]));
            result=Math.max(result,max[i]);
        }
        return result;
    }
    //method2 内存优化
    public static int maxProduct1(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int currMax=nums[0];
        int currMin=nums[0];
        int result=currMax;

        for (int i = 1; i < len; i++) {
            int nextMax=currMax*nums[i];
            int nextMin=currMin*nums[i];
            currMax=Math.max(nums[i],Math.max(nextMax,nextMin));
            currMin=Math.min(nums[i],Math.min(nextMax,nextMin));
            result=Math.max(result,currMax);
        }
        return result;
    }

}
