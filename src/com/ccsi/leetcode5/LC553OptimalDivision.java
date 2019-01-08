package com.ccsi.leetcode5;

public class LC553OptimalDivision {
    public static void main(String[] args) {
        int[] nums={1000,100,10,2};
        System.out.println(optimalDivision(nums));
    }
    public static String optimalDivision(int[] nums){
        Result result=getMax(nums,0,nums.length-1);
        return result.str;
    }
    private static Result getMax(int[] nums,int start,int end){
        Result result=new Result();
        result.val=-1.0;

        if(start==end){
            result.str=nums[start]+"";
            result.val=(double)nums[start];
        }else if(start+1==end){
            result.str=nums[start]+"/"+nums[end];
            result.val=(double) nums[start]/nums[end];
        }else{
            for (int i = start; i < end; i++) {
                Result r1=getMax(nums,start,i);
                Result r2=getMin(nums,i+1,end);
                if(r1.val/r2.val> result.val){
                    result.str=r1.str+"/"+(end-i>=2?"("+r2.str+")":r2.str);
                    result.val=r1.val/r2.val;
                }
            }
        }
        return result;
    }

    private static Result getMin(int[] nums,int start,int end){
        Result result=new Result();
        result.val=Double.MAX_VALUE;

        if(start==end){
            result.str=nums[start]+"";
            result.val=(double) nums[start];
        }else if(start+1==end){
            result.str=nums[start]+"/"+nums[end];
            result.val=(double) nums[start]/nums[end];
        }else{
            for (int i = start; i < end; i++) {
                Result r1=getMin(nums,start,i);
                Result r2=getMax(nums,i+1,end);
                if(r1.val/r2.val<result.val){
                    result.str=r1.str+"/"+(end-i>=2?"("+r2.str+")":r2.str);
                    result.val=r1.val/r2.val;
                }
            }
        }

        return result;
    }
    private static class Result{
        String str;
        double val;
    }
}

