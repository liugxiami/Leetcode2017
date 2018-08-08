package com.ccsi.leetcode4;

public class LC453MinimumMovesToEqualElements {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(minMoves1(nums));
    }
    /*
    这道题给了我们一个长度为n的数组，说是我们每次可以对n-1个数字同时加1，问最少需要多少次这样的操作才能让数组中所有的数字相等。
    那么我们想，为了快速的缩小差距，该选择哪些数字加1呢，不难看出每次需要给除了数组最大值的所有数字加1，这样能快速的到达平衡状态。
    但是这道题如果我们老老实实的每次找出最大值，然后给其他数字加1，再判断是否平衡，思路是正确，但是OJ不答应。正确的解法相当的巧妙，
    需要换一个角度来看问题，其实给n-1个数字加1，效果等同于给那个未被选中的数字减1，比如数组[1，2，3], 给除去最大值的其他数字加1，
    变为[2，3，3]，我们全体减1，并不影响数字间相对差异，变为[1，2，2]，这个结果其实就是原始数组的最大值3自减1，那么问题也可能转
    化为，将所有数字都减小到最小值，这样难度就大大降低了，我们只要先找到最小值，然后累加每个数跟最小值之间的差值即可
     */
    public static int minMoves(int[] nums){
        if(nums==null||nums.length<2)return 0;
        int min=Integer.MAX_VALUE;
        int result=0;
        for(int num:nums)min=Math.min(min,num);
        for(int num:nums)result+=num-min;
        return result;
    }
    /*
    math
    sum+m*(n-1)=x*n
    x=min+m
    ==>m=sum-min*n;
     */
    public static int minMoves1(int[] nums){
        if(nums==null||nums.length<2)return 0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            sum+=num;
            min=Math.min(min,num);
        }
        return sum-min*nums.length;
    }
}
