package com.ccsi.leetcode3;

/**
 * Created by gxliu on 2018/2/25.
 */
public class LC327CountOfRangeSum {
    //method1 O(n^2)
    public static int countRangeSum(int[] nums,int lower,int upper){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        int[] aux=new int[len];
        aux[0]=nums[0];
        for (int i = 1; i < len; i++) {
            aux[i]=aux[i-1]+nums[i];
        }
        int count=0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                int temp=0;
                if(j==0)temp=aux[i];
                else temp=aux[i]-aux[j-1];

                if(temp>=lower&&temp<=upper)count++;
            }
        }
        return count;
    }
    //method2 binary
    private long[] cache;
    private int lower;
    private int upper;
    public int countRangeSum1(int[] nums,int lower,int upper){
        if(nums==null||nums.length==0)return 0;
        int len=nums.length;
        cache=new long[len];

        this.lower=lower;
        this.upper=upper;

        cache[0]=nums[0];
        for (int i = 1; i < len; i++) {
            cache[i]=cache[i-1]+nums[i];
        }

        return helper(nums,0,len-1);
    }
    //二分法
    private int helper(int[] nums,int left,int right){
        if(left==right){
            if(lower<=nums[left]&&nums[right]<=upper)return 1;
            else return 0;
        }

        int middle=(right-left)/2+left;
        int total=0;
        for (int i = left; i <=middle; i++) {
            for (int j = middle+1; j <= right; j++) {
                long temp=cache[j]-cache[i]+nums[i];
                if(temp>=lower&&temp<=upper)total++;
            }
        }

        return total+helper(nums,left,middle)+helper(nums,middle+1,right);
    }

    public static void main(String[] args) {
        int[] nums={2,5,1,4,9,3};
        LC327CountOfRangeSum sum=new LC327CountOfRangeSum();
        System.out.println(sum.countRangeSum1(nums,0,5));
    }
}
