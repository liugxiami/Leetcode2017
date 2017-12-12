package com.ccsi.leetcode1;

/**
 * Created by gxliu on 2017/12/11.
 */
public class LC213HouseRobberII {
    //因为这是个环形houses了，那么就是偷了第一家就不能偷最后一家（第一家和最后一家相邻），那么可以这样来看，找到投第一家到倒数第二家能
    //偷到的最大值；在找到偷从第二家开始到最后一家能偷到的最大值，比较这两个最大值，得到结果。
    //其写法完全可以借用robI的方法做稍微的改进，将起始和结尾以参数形式传进去。
    public static int rob(int[] nums){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        if(len==1)return nums[0];
        if(len==2)return Math.max(nums[0],nums[1]);

        return Math.max(rob(nums,0,len-2),rob(nums,1,len-1));
    }
    //对rob 1略微改进，加入start和end两参数，表示可以从什么地方偷到什么地方。进一步的还可以降维。
    private static int rob(int[] nums,int start,int end){
        if(start==end)return nums[start];
        if(end-start==1)return Math.max(nums[start],nums[end]);

        int[] cache=new int[nums.length+1];
        cache[start]=nums[start];
        cache[start+1]=Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <=end ; i++) {
            cache[i]=Math.max(nums[i]+cache[i-2],cache[i-1]);
        }
        return cache[end];
    }

    public static void main(String[] args) {
        int[] nums={2,6,3,5,7};
        System.out.println(rob(nums));
    }
}
