package com.ccsi.leetcode4;

/**
 * Created by gxliu on 2018/5/29.
 */
public class LC416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums={1,5,11,5};
        System.out.println(canPartitionDP(nums));
    }
    public static boolean canPartition(int[] nums){
        if(nums==null||nums.length<2)return false;
        long sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%2==1)return false;
        else{
            return backTrack(nums,sum/2,sum,0);
        }

    }
    //backtracking
    public static boolean backTrack(int[] nums,long half,long remain,int index){
        boolean res=false;
        if(remain==half)res=true;
        else{
            for (int i = index; i < nums.length; i++) {
                remain-=nums[index];
                res|=backTrack(nums,half,remain,i+1);
                remain+=nums[index];
            }
        }

        return res;
    }
    //DP
    public static boolean canPartitionDP(int[] nums){
        if(nums==null||nums.length<2)return false;
        int sum=0; //先求总和
        for(int num:nums){
            sum+=num;
        }
        if(sum%2==1)return false; //总和是奇数的话，肯定不能分成两相同的份
        boolean[] dp=new boolean[sum+1]; //dp[i][j]表示前i个数的总和为j，如果dp[i][j]成立，那么
        //dp[i-1][j-num[i]]也成立。这种滚动数组可以压缩为一维。
        dp[0]=true; //初始化
        for(int num:nums){ //对每一个数迭代
            for (int i = sum; i >=0 ; i--) { //小技巧，反着来看
                if(dp[i])dp[i+num]=true; //如果dp[i]存在，那么dp[i+num]也存在
                if(dp[sum/2])return true; //随时check总和的一半是否存在，如果存在就可以中断寻找了。
            }
        }
        return false;
    }
}
