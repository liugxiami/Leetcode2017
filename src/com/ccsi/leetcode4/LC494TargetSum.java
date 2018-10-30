package com.ccsi.leetcode4;

public class LC494TargetSum {
    public static void main(String[] args) {
        int[] nums={1,1,1,1,1};
        System.out.println(findTargetSumWaysDP(nums,6));
    }
    //method1 递归，对于每一位数，都有两种可能。典型的递归就可以做了，从第一位开始，每进一位，做两种选择，一是加上这个数
    //一是减去这个数。如果到了结尾，也就是index到了最后一位的后一位，也就是没有了，判断一下此时的sum就可以了。
    //但我估计这种算法通不过OJ。
    private static int counts;
    public static int findTargetSumWays(int[] nums,int S){
        if(nums==null||nums.length==0)return 0;
        counts=0;
        find(nums,0,0,S);
        return counts;
    }
    private static void find(int[] nums,int index,int sum,int S){
        if(index==nums.length){
            if(sum==S)counts++;
            return;
        }
        find(nums,index+1,sum+nums[index],S);
        find(nums,index+1,sum-nums[index],S);
    }
    //method2
    /*  P-positive N-negative
        sum(P) all positive num's sum
        sum(N) all negative num's sum
                       sum(P) - sum(N) = target
     sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                            2 * sum(P) = target + sum(nums)
     */
    public static int findTargetSumWaysDP(int[] nums,int S){
        if(nums==null||nums.length==0)return 0;
        int sum=0;
        for(Integer num:nums) sum+=num;
        //如果总和小于S，那肯定不可能有这样的组合，那么返回0；如果根据上面的数学推导，如果sum+S不是2的整数倍，那么也不可能有这样的组合，
        //返回0，否则就计算有多少个这样的组合。
        //参考LC416的DP解题方法。
        return sum<S||(sum+S)%2!=0?0:subsetSum(nums,(sum+S)>>1);
    }
    private static int subsetSum(int[] nums,int s){
        //DP[i]表示sum为i时的way有多少种。
        int[] DP=new int[s+1];
        DP[0]=1;
        for(Integer num:nums){
            for (int i = s; i >=num ; i--) {
                DP[i]+=DP[i-num];
            }
        }
        return DP[s];
    }
}
